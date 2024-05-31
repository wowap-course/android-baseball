package com.example.baseball.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseball.domain.Life

class MainViewModel : ViewModel() {

    private val _life: MutableLiveData<Life> = MutableLiveData(Life(value = INIT_LIFE_COUNT))
    val life: LiveData<Life> = _life

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event> = _event
    fun decreaseLife() {
        if (life.value?.value == MIN_LIFE_COUNT) {
            _event.value = Event.ShowErrorMessage("목숨은 최대 10입니다")
        }
        _life.value = life.value?.dec()
    }

    fun increaseLife() {
        if (life.value?.value == MAX_LIFE_COUNT) {
            _event.value = Event.ShowErrorMessage("목숨은 최소 1입니다.")
        }
        _life.value = life.value?.inc()
    }

    fun startGame() {
        _event.value = Event.NavigateToGame
    }

    companion object {
        private const val INIT_LIFE_COUNT = 1
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 10
    }
}

sealed interface Event {
    data object NavigateToGame : Event
    data class ShowErrorMessage(val message: String) : Event
}