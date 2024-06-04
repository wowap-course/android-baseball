package com.example.baseball.Game

import Count
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import baseball.domain.Game
import baseball.domain.numbergenerator.RandomNumberGenerator
import com.example.baseball.domain.Life


class GameViewModel(initialLife: Int) : ViewModel() {

    private val randomNumber = RandomNumberGenerator().getNumbers()
    private val game: Game = Game(randomNumber)
    private val _life: MutableLiveData<Life> =
        MutableLiveData(Life(value = initialLife))
    var life: LiveData<Life> = _life

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event> = _event

    private val counts: MutableList<Count> = mutableListOf()

    fun game(inputNumber: List<Int>) {
        _life.value = life.value?.dec()
        val referee = game.resultCount(inputNumber)
        counts.add(Count(referee.strikeCount, referee.ballCount, inputNumber))

        when {
            referee.strikeCount == WIN_CONDITION -> {
                _event.value = Event.ShowWinDialog(answerNumber = game.answerNumbers)
            }

            life.value?.value == LOST_CONDITION -> {
                _event.value = Event.ShowLoseDialog(answerNumber = game.answerNumbers)
            }

            else -> {
                _event.value = Event.ShowResult(counts = counts)
            }
        }
    }

    companion object {

        private const val WIN_CONDITION = 3 // 승리 조건
        private const val LOST_CONDITION = 0 // 패배 조건

        class GameViewModelFactory(private val life: Int) : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
                    return GameViewModel(life) as T
                }
                throw IllegalArgumentException()
            }
        }
    }

}


sealed interface Event {
    data class ShowWinDialog(val answerNumber: List<Int>) : Event
    data class ShowLoseDialog(val answerNumber: List<Int>) : Event
    data class ShowResult(val counts: MutableList<Count>) : Event
}