package com.example.baseball.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseball.domain.LifeCount

class MainViewModel : ViewModel() {
    private val _lifeCount : MutableLiveData<LifeCount> = MutableLiveData(LifeCount())
    val lifeCount : LiveData<LifeCount> = _lifeCount

    private val _event : MutableLiveData<Event> = MutableLiveData()
    val event : LiveData<Event> = _event
    fun increaseLife() {
        if (lifeCount.value?.count == 10) {
            _event.value = Event.ShowErrorMessage("목숨은 최대 10개 입니다.")
            return
        }
        _lifeCount.value = lifeCount.value?.inc()
    }

    fun decreaseLife() {
        if(lifeCount.value?.count == 1) {
            _event.value = Event.ShowErrorMessage("목숨은 최소 1개 입니다.")
            return
        }
        _lifeCount.value = lifeCount.value?.dec()
    }

    fun gameStart() {
        _event.value = Event.NavigateToGame
    }

}
