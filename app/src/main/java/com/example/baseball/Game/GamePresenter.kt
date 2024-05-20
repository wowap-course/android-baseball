package com.example.baseball.Game

import baseball.domain.Game
import baseball.domain.numbergenerator.RandomNumberGenerator


class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {

    private val game:Game = Game(RandomNumberGenerator().getNumbers())
    override fun randomNumberGenerator(): List<Int> {
        return RandomNumberGenerator().getNumbers()
    }

    override fun game( inputNumber: List<Int>, lifeCount: Int?) {
        val count = game.start(inputNumber, lifeCount!!.toInt())
        when{
            count.strikeCount == 3 -> view.showWinDialog(game.answerNumbers)
            count.lifeCount == 0 -> view.showLoseDialog(game.answerNumbers)
            else ->  view.showResult(count.strikeCount, count.ballCount, count.lifeCount)
        }
    }
}