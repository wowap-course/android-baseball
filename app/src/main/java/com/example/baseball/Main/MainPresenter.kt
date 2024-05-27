package com.example.baseball.presentation.main

import com.example.baseball.Main.MainContract
import com.example.baseball.domain.Life

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    private var life = Life(1)

    init {
        view.showLife(life.value)
    }

    override fun decreaseLife() {
        life --
        view.showLife(life.value)
    }

    override fun increaseLife() {
        life ++
        view.showLife(life.value)
    }

    override fun startGame() {
        view.startGamePage(life.value)
    }
}
