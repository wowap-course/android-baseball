package com.example.baseball.domain

import com.example.baseball.domain.numbergenerator.RandomNumberGenerator

class BaseballGame {
    private val judgement = Judgement()
    private var tryCount = 0
    val opponentNumber: List<BaseballNumber> =
        BaseballNumbers(RandomNumberGenerator().generateNumber()).baseballNumbers

    fun playOnrRound(answer: String): BaseballScore {
        tryCount++
        val baseballNumberAnswer = BaseballNumbers(
            answer.toList().map { it.toString().toInt() }).baseballNumbers
        val scoreOfInning = judgement.judgeNumber(opponentNumber, baseballNumberAnswer, tryCount)
        return scoreOfInning
    }
}