package com.example.baseball.presentation.game

import android.util.Log
import com.example.baseball.domain.BaseballNumber
import com.example.baseball.domain.BaseballNumbers
import com.example.baseball.domain.Judgement
import com.example.baseball.domain.numbergenerator.RandomNumberGenerator

class GamePresenter(private val view: GameContract.View, private val life: Int) :
    GameContract.Presenter {
    private val opponentNumber: List<BaseballNumber> =
        BaseballNumbers(RandomNumberGenerator().generateNumber()).baseballNumbers
    private val judgement = Judgement()
    private var remainingLife = life

    fun isGameOver() = remainingLife == DEAD
    override fun playOneRound(answer: String) {
        val baseballNumberAnswer = BaseballNumbers(
            answer.toList().map { it.toString().toInt() }).baseballNumbers // 올바른 값만 입력된다고 가정
        val (ball, strike) = judgement.judgeNumber(opponentNumber, baseballNumberAnswer)

        remainingLife--
        view.showLifeCount(remainingLife)

        if (strike == MAX_STRIKE)
            view.showResultOfGame(SUCCESS, opponentNumber.joinToString("").toInt())
        else if (isGameOver())
            view.showResultOfGame(FAIL, opponentNumber.joinToString("").toInt())
        else view.showResultOfInning(ball, strike)
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