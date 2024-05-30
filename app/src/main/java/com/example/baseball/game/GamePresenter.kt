package com.example.baseball.game

import com.example.baseball.game.baseballcounts.BaseballCountItem
import com.example.domain.domain.numbergenerator.RandomNumberGenerator
import com.example.baseball.domain.Life
import com.example.domain.domain.BaseballCount
import com.example.domain.domain.BaseballGame
import com.example.domain.domain.GameResult

class GamePresenter(
    private val view: GameContract.View, initialLife: Int
) : GameContract.Presenter {

    private val baseballGame: BaseballGame = BaseballGame(RandomNumberGenerator().getNumbers())
    private var life = Life(initialLife)

    init {
        view.showLife(life.value)
    }

    override fun challenge(inputNumber: List<Int>) {
        useLife()
        val result = baseballGame.play(inputNumber, life)

        when (result) {
            GameResult.WIN -> view.showWinDialog(baseballGame.answerNumbers)
            GameResult.LOSE -> view.showLoseDialog(baseballGame.answerNumbers)
            GameResult.CONTINUE -> view.showResult(
                baseballGame.baseballCounts.toPresentation(inputNumber)
            )
        }
    }

    private fun useLife() {
        life--
        view.showLife(life.value)
    }

    private fun List<BaseballCount>.toPresentation(inputNumber: List<Int>): List<BaseballCountItem> {
        return map { BaseballCountItem(it.strikeCount, it.ballCount, inputNumber) }
    }
}

