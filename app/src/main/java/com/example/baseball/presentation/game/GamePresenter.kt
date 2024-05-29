package com.example.baseball.presentation.game

import android.util.Log
import com.example.baseball.domain.numbergenerator.BaseballGame

class GamePresenter(private val view: GameContract.View, private val life: Int) :
    GameContract.Presenter {
    private val baseballGame = BaseballGame()
    private var remainingLife = life

    private fun isGameOver() = remainingLife == DEAD

    override fun onTryBtnClicked(answer: String) {
        remainingLife--
        view.showLifeCount(remainingLife)

        val score = baseballGame.playOnrRound(answer)

        if (score.strike == MAX_STRIKE)
            view.showResultOfGame(SUCCESS, baseballGame.opponentNumber.joinToString("").toInt())
        else if (isGameOver())
            view.showResultOfGame(FAIL, baseballGame.opponentNumber.joinToString("").toInt())
        else view.showResultOfInning(
            score.tryCount,
            score.ball,
            score.strike,
            score.answerOfInning
        )
    }

    override fun onRestartBtnClicked() {
        view.restartGameActivity(life)
    }

    override fun onExitBtnClicked() {
        view.navigateToMainActivity()
    }

    companion object {
        private const val MAX_STRIKE = 3
        private const val SUCCESS = "성공"
        private const val FAIL = "실패"
        private const val DEAD = 0
    }
}