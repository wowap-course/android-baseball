package com.example.baseball.presentation.main

import com.example.baseball.domain.LifeCount

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    private var lifeCount = LifeCount(1)

    init {
        view.showLife(lifeCount.count)
    }

    override fun increaseLife() {
        lifeCount++
        view.showLife(lifeCount.count)
    }

    override fun decreaseLife() {
        lifeCount--
        view.showLife(lifeCount.count)
    }

    override fun onGameStartBtnClicked() {
        view.navigateToGameActivity(lifeCount.count)
    }
}