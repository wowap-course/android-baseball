package com.example.baseball.presentation.main

import com.example.baseball.Main.MainContract
import com.example.baseball.domain.Life

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {

    private var life = Life(INIT_LIFE_COUNT)

    init {
        view.showLife(life.value)
    }

    override fun decreaseLife() {
        if (life.value == MIN_LIFE_COUNT) return
        life--
        view.showLife(life.value)
    }

    override fun increaseLife() {
        life++
        view.showLife(life.value)
    }

    override fun startGame() {
        view.startGamePage(life.value)
    }

    companion object{
        private const val INIT_LIFE_COUNT = 1
        private const val MIN_LIFE_COUNT = 1
    }
}
