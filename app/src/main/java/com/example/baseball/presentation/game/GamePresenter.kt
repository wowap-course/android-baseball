package com.example.baseball.presentation.game

import android.util.Log
import com.example.baseball.domain.BaseballNumber
import com.example.baseball.domain.BaseballNumbers
import com.example.baseball.domain.Judgement
import com.example.baseball.domain.numbergenerator.RandomNumberGenerator

class GamePresenter(private val view: GameContract.View, private var remainingLife: Int) :
    GameContract.Presenter {
    private val opponentNumber: List<BaseballNumber> =
        BaseballNumbers(RandomNumberGenerator().generateNumber()).baseballNumbers
    private val judgement = Judgement()

    fun isGameOver() = remainingLife == 0
    override fun playOneRound(answer: String) {
        val baseballNumberAnswer = BaseballNumbers(
            answer.toList().map { it.toString().toInt() }).baseballNumbers // 올바른 값만 입력된다고 가정
        val (ball, strike) = judgement.judgeNumber(opponentNumber, baseballNumberAnswer)

        remainingLife--
        view.showLifeCount(remainingLife)

        if (strike == 3)
            view.showResultOfGame("성공", opponentNumber.joinToString("").toInt())
        else if (isGameOver())
            view.showResultOfGame("실패", opponentNumber.joinToString("").toInt())
        else view.showResultOfInning(ball, strike)
    }
}