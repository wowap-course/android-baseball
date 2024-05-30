package com.example.baseball.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseball.domain.Life

class MainViewModel : ViewModel() {

    private val _life: MutableLiveData<Life> = MutableLiveData(/* value = */ Life(1))
    val life: LiveData<Life> = _life

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event> = _event

    fun decreaseLife() {
        if (life.value?.value == 1) {
            _event.value = Event.ShowErrorMessage("목숨은 최대 10 입니다.")
            return
        }
        _life.value = life.value?.dec()
    }

    fun increaseLife() {
        if (life.value?.value == 10) {
            _event.value = Event.ShowErrorMessage("목숨은 최소 1 입니다.")
            return
        }
        _life.value = life.value?.inc()
    }

    fun gameStart() {
        _event.value = Event.NavigateToGame
    }
}

sealed interface Event {
    data object NavigateToGame : Event
    data class ShowErrorMessage(val message: String) : Event
}

