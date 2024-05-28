package com.example.baseball.domain

data class BaseballScore (
    val tryCount : Int,
    val ball : Int,
    val strike : Int,
    val answerOfInning : String
) {
    init {
        require(tryCount > 0)
        require(ball in (0..3))
        require(strike in (0..3))
        require(answerOfInning.toIntOrNull() != null)
        require(answerOfInning.length == 3)
        require(answerOfInning.toSet().size == answerOfInning.length)
    }
}