package com.example.baseball.presentation.game

import com.example.baseball.domain.BaseballGame

class GamePresenter(private val view: GameContract.View, private val life: Int) :
    GameContract.Presenter {
    private val baseballGame = BaseballGame()
    private var remainingLife = life

    private fun isGameOver() = remainingLife == DEAD

    override fun onTryBtnClicked(answer: String) {
        if (answer == "") {
            view.showRequests(REQUEST_INPUT)
            return
        }
        if (answer.toSet().size != answer.length) {
            view.showRequests(REQUEST_NO_DUPLICATE)
            return
        }

        remainingLife--
        view.showLifeCount(remainingLife)

        val score = baseballGame.playOnrRound(answer)

        if (score.strike == MAX_STRIKE)
            view.showResultOfGame(SUCCESS, baseballGame.opponentNumber.joinToString("").toInt())
        else if (isGameOver())
            view.showResultOfGame(FAIL, baseballGame.opponentNumber.joinToString("").toInt())
        else view.showResultOfInning(
            score.ball,
            score.strike,
            score.answerOfInning.map { it.toInt() }
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
        private const val REQUEST_INPUT = "숫자를 입력해주세요."
        private const val REQUEST_NO_DUPLICATE = "숫자는 중복될 수 없어요."
    }
}