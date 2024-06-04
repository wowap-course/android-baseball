package com.example.baseball.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseball.domain.BaseballGame
import com.example.baseball.domain.BaseballScore
import com.example.baseball.domain.LifeCount

class GameViewModel(life : Int) : ViewModel() {
    private val baseballGame = BaseballGame()
    private val _remainingLife : MutableLiveData<LifeCount> = MutableLiveData(LifeCount(life))
    val remainingLife : LiveData<LifeCount> = _remainingLife

    private val _score : MutableLiveData<BaseballScore> = MutableLiveData()
    val score : LiveData<BaseballScore> = _score

    private val _event : MutableLiveData<Event> = MutableLiveData()
    val event : LiveData<Event> = _event

    private fun isGameOver() = remainingLife.value == DEAD_LIFE

    fun onTryBtnClicked(answer : String) {
        if (answer == "" || answer.length != INPUT_DIGITS) {
            _event.value = Event.ShowRequests(REQUEST_INPUT)
            return
        }
        if (answer.toSet().size != answer.length) {
            _event.value = Event.ShowRequests(REQUEST_NO_DUPLICATE)
            return
        }

        remainingLife.value?.dec()
        _score.value = baseballGame.playOnrRound(answer)

        if (score.value?.strike == MAX_STRIKE)
            _event.value = Event.ShowResult(SUCCESS, baseballGame.opponentNumber.joinToString("").toInt())
        else if (isGameOver())
            _event.value = Event.ShowResult(FAIL, baseballGame.opponentNumber.joinToString("").toInt())
    }

    companion object {
        private const val MAX_STRIKE = 3
        private const val SUCCESS = "성공"
        private const val FAIL = "실패"
        private val DEAD_LIFE = LifeCount(0)
        private const val REQUEST_INPUT = "세자리 숫자를 입력해주세요."
        private const val REQUEST_NO_DUPLICATE = "숫자는 중복될 수 없어요."
        private const val INPUT_DIGITS = 3
    }
}