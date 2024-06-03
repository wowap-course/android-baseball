package com.example.baseball.domain.numbergenerator

import com.example.baseball.domain.BaseballNumber
import com.example.baseball.domain.BaseballNumbers
import com.example.baseball.domain.BaseballScore
import com.example.baseball.domain.Judgement

class BaseballGame() {
    private var tryCount = INIT_TRY
    private val judgement = Judgement()
    private val _baseballScores = ArrayList<BaseballScore>()
    val opponentNumber: List<BaseballNumber> =
        BaseballNumbers(RandomNumberGenerator().generateNumber()).baseballNumbers
    val baseballScores get() = _baseballScores.toList()

    fun playOnrRound(answer: String): BaseballScore {
        val baseballNumberAnswer = BaseballNumbers(
            answer.toList().map { it.toString().toInt() }).baseballNumbers // 올바른 값만 입력된다고 가정
        val scoreOfInning = judgement.judgeNumber(opponentNumber, baseballNumberAnswer)

        _baseballScores.add(0, scoreOfInning)

        return scoreOfInning
    }

    companion object {
        private const val INIT_TRY = 1
    }
}