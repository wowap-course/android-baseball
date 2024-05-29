package com.example.domain.domain

import com.example.baseball.domain.Life

class BaseballGame(val answerNumbers: List<Int>) {

    private val _baseballCounts: MutableList<BaseballCount> = mutableListOf()
    val baseballCounts: List<BaseballCount>
        get() = _baseballCounts.toList()

    fun play(inputBaseballNumber: List<Int>, life: Life): GameResult {
        val referee = Judgement().correctCount(answerNumbers, inputBaseballNumber)
        _baseballCounts.add(referee)

        return when {
            referee.strikeCount == WINNING_STRIKE_COUNT -> GameResult.WIN
            life.value == LOSE_LIFE -> GameResult.LOSE
            else -> GameResult.CONTINUE
        }
    }

    companion object {
        private const val WINNING_STRIKE_COUNT = 3
        private const val LOSE_LIFE = 0
    }
}
