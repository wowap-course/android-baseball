package com.example.baseball.domain

class Judgement() {
    fun judgeNumber(
        opponentNumber: List<BaseballNumber>,
        answer: List<BaseballNumber>
    ): Pair<Int, Int> {
        val strike = countStrikes(opponentNumber, answer)
        val allBall = countAllBall(opponentNumber, answer)
        val ball = allBall - strike
        return ball to strike
    }

    private fun countAllBall(
        opponentNumber: List<BaseballNumber>,
        answer: List<BaseballNumber>
    ): Int =
        opponentNumber.count { answer.contains(it) }

    private fun countStrikes(
        opponentNumber: List<BaseballNumber>,
        answer: List<BaseballNumber>
    ): Int =
        opponentNumber.zip(answer).count { it.first == it.second }
}