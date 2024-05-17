package com.example.baseball.Game

import baseball.domain.Game
import baseball.domain.numbergenerator.RandomNumberGenerator


class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {
    override fun game(inputNumber: List<Int>) {
        val randomNumber = RandomNumberGenerator().getNumbers()
        val count = Game().start(randomNumber, inputNumber)
        view.showResult(count.strikeCount, count.ballCount)
    }
}