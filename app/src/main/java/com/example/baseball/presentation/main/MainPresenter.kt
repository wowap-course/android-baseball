package com.example.baseball.presentation.main

import com.example.baseball.domain.LifeCount

class MainPresenter(private val view : MainContract.View) : MainContract.Presenter {
    private var lifeCount = LifeCount()
    init {
        view.showLife(lifeCount.count)
    }
    override fun increaseLife() {
        if (lifeCount.increase()) view.showLife(lifeCount.count)
        else view.showMaxLife()
    }

    override fun decreaseLife() {
        if (lifeCount.decrease()) view.showLife(lifeCount.count)
        else view.showMinLife()
    }
}