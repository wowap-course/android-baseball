package com.example.baseball.presentation

//import com.example.baseball.displayBoard.BoardItems
import com.example.baseball.domain.BoardItems
import com.example.baseball.domain.Referee
import com.example.baseball.domain.numberRules.ThreeRandomNumberGenerator
import com.example.baseball.domain.Life
import com.example.baseball.domain.contracts.GamePlayContract

class GamePlayPresenter(private val view: GamePlayContract.View, initialLife: Int) : GamePlayContract.Presenter {
    private var life = Life(initialLife)
    private val referee = Referee()
    private val gameSetup = ThreeRandomNumberGenerator()
    private val computer = gameSetup.generateNumber()
    private var trytime = 1

    override fun decreaseLife() {
        view.showLife(life.decreaseToZero())
    }

    override fun playgame(playerNumber: List<Int>) {
        playHandler(computer, playerNumber)
    }

    override fun playHandler(computer: List<Int>, player: List<Int>) {
        try {
            val validPlayerNumber = checkNumber(player)
            val (strike, ball) = referee.call(computer, validPlayerNumber)
            referee.reset()
            view.showGameStatus(trytime, strike, ball, validPlayerNumber)
            trytime++
            if (referee.isThreeStrike(strike)) {
                view.showGameResult("성공", computer)
            } else {
                decreaseLife()
                if (referee.callGameOver(life.count)) {
                    view.showGameResult("실패", computer)
                }
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    override fun checkNumber(inputs: List<Int>): List<Int> {
        if (inputs.size != MAX_INPUT_NUMBER) {
            throw IllegalArgumentException("입력값이 3개가 아닙니다.")
        }
        return inputs
    }

    companion object {
        const val MAX_INPUT_NUMBER = 3
    }
}
