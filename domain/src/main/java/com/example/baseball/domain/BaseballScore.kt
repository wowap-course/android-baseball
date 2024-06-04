package com.example.baseball.domain

data class BaseballScore(
    val tryCount : Int,
    val ball: Int,
    val strike: Int,
    val answerOfInning: List<BaseballNumber>
) {
    init {
        require(tryCount > MIN_TRY_COUNT)
        require(ball in BALL_SCORE_RANGE)
        require(strike in STRIKE_SCORE_RANGE)
        require(answerOfInning.size == DIGITS_OF_ANSWER)
        require(answerOfInning.toSet().size == answerOfInning.size)
    }

    companion object {
        private const val MIN_TRY_COUNT = 0
        private val BALL_SCORE_RANGE = 0..3
        private val STRIKE_SCORE_RANGE = 0..3
        private const val DIGITS_OF_ANSWER = 3
    }
}