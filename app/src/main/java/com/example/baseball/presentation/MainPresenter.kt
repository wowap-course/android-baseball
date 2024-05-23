package com.example.baseball.presentation

import com.example.baseball.domain.Life
import com.example.baseball.domain.Life.Companion.MIN_LIFE
import com.example.baseball.domain.contracts.MainContract

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    private var life = Life(MIN_LIFE)

    init {
        view.showLife(life.count)
    }
    override fun decreaseLife() {
        view.showLife(life.decrease())
    }

    override fun increaseLife() {
        view.showLife(life.increase())
    }
}