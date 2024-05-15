package com.example.baseball.presentation

import com.example.baseball.domain.Life
import com.example.baseball.domain.Life.Companion.MIN_LIFE
import com.example.baseball.domain.contracts.GamePlayContract

class GamePlayPresenter(private val view: GamePlayContract.View): GamePlayContract.Presenter {
    private var life = Life(MIN_LIFE)
    override fun decreaseLife() {
        view.showLife(life.decrease())
    }

}