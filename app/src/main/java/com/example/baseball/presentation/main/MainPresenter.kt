package com.example.baseball.presentation.main

import com.example.baseball.domain.model.Life

class MainPresenter(
    private val view: MainContract.View
) : MainContract.Presenter {

    private var life = Life(1)

    init {
        view.showLife(life.value)
    }

    override fun decreaseLife() {
        life--
        view.showLife(life.value)
    }

    override fun increaseLife() {
        life++
        view.showLife(life.value)
    }

    override fun gameStart() {
        view.navigateToGame(life.value)
    }
}
