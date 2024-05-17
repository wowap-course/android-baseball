package com.example.baseball.presentation

import baseball.domain.Referee
import baseball.domain.numberRules.ThreeRandomNumberGenerator
import com.example.baseball.domain.Life
import com.example.baseball.domain.Life.Companion.MIN_LIFE
import com.example.baseball.domain.contracts.GamePlayContract

class GamePlayPresenter(private val view: GamePlayContract.View): GamePlayContract.Presenter {
    private var life = Life(MIN_LIFE)
    private val referee = Referee()
    private val gameSetup = ThreeRandomNumberGenerator()
    private val computer = gameSetup.generateNumber()
    override fun decreaseLife() {
        view.showLife(life.decrease())
    }

    override fun playgame(playerNumber: List<Int>) {
        playHandler(computer, playerNumber)
    }

    private fun playHandler(computer: List<Int>, player: List<Int>): Boolean {
        return try {
            val validPlayerNumber = checkNumner(player)
            val (strike, ball) = referee.call(computer, validPlayerNumber)
            referee.reset()
            view.showGameStatus(strike, ball)
            true
        } catch (e: IllegalArgumentException) {
            println(e.message)
            false
        }
    }

    private fun checkNumner(inputs: List<Int>): List<Int> {
        if (inputs.size != 3) {
            throw IllegalArgumentException("입력값이 3개가 아닙니다.")
        }
        return inputs
    }
}