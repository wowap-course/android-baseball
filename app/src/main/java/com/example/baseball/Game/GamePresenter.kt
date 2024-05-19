package com.example.baseball.Game

import baseball.domain.Game
import baseball.domain.numbergenerator.RandomNumberGenerator


class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {
    override fun randomNumberGenerator(): List<Int> {
        return RandomNumberGenerator().getNumbers()
    }

    override fun game(randomNumber:List<Int>, inputNumber: List<Int>, lifeCount: Int?) {
        val count = Game().start(randomNumber, inputNumber, lifeCount!!.toInt())
        view.showResult(count.strikeCount, count.ballCount, count.lifeCount)
    }
}