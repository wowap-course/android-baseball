package com.example.baseball.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baseball.domain.Life
import com.example.baseball.domain.Life.Companion.MIN_LIFE

class MainViewModel: ViewModel() {
    private val _life: MutableLiveData<Life> = MutableLiveData(Life(MIN_LIFE))
    val life: LiveData<Life> = _life

    fun decreaseLife() {
        _life.value = life.value?.decrease()
    }

    fun increaseLife() {
        _life.value = life.value?.increase()
    }
}

//class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
//    private var life = Life(MIN_LIFE)
//
//    init {
//        view.showLife(life.count)
//    }
//    override fun decreaseLife() {
//        view.showLife(life.decrease())
//    }
//
//    override fun increaseLife() {
//        view.showLife(life.increase())
//    }
//}