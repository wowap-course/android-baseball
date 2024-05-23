package com.example.baseball.domain

import com.example.baseball.domain.Life.Companion.ZERO_LIFE

class Referee {
    private val score = Score(RESET_NUMBER, RESET_NUMBER)

    fun call(computerNumbers: List<Int>, playerNumbers: List<Int>): Pair<Int, Int> {
        for (i in computerNumbers.indices) {
            if (computerNumbers[i] == playerNumbers[i]) {
                score.strike++
            } else if (playerNumbers.contains(computerNumbers[i])) {
                score.ball++
            }
        }

        return score.strike to score.ball
    }

    fun isThreeStrike(strike: Int): Boolean {
        return strike == THREE_STRIKE
    }

    fun callGameOver(life: Int): Boolean {
        return life == ZERO_LIFE
    }

    fun reset() {
        score.strike = RESET_NUMBER
        score.ball = RESET_NUMBER
    }

    companion object {
        const val MIN_RANDOM_NUMBER = 1
        const val MAX_RANDOM_NUMBER = 9
        const val THREE_STRIKE = 3
        const val RESET_NUMBER = 0
        const val MAX_COM_NUMBER_SIZE = 3
    }
}
