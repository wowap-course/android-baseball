package com.example.baseball.Game

import Count
import baseball.domain.Game
import baseball.domain.numbergenerator.RandomNumberGenerator
import com.example.baseball.domain.Life


class GamePresenter(private val view: GameContract.View, initialLife: Int) :
    GameContract.Presenter {

    private val game: Game = Game(RandomNumberGenerator().getNumbers())
    private var life = Life(initialLife)
    private val counts: MutableList<Count> = mutableListOf()

    init {
        view.showLife(life.value)
    }

    override fun randomNumberGenerator(): List<Int> {
        return RandomNumberGenerator().getNumbers()
    }

    override fun game(inputNumber: List<Int>) {
        life--
        view.showLife(life.value)

        val referee = game.resultCount(inputNumber)
        counts.add(Count(referee.strikeCount, referee.ballCount, inputNumber))

        when {
            referee.strikeCount == 3 -> view.showWinDialog(game.answerNumbers)
            life.value == 0 -> view.showLoseDialog(game.answerNumbers)
            else -> view.showResult(counts)
        }
    }
}