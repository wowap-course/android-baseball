package baseball.domain

import baseball.domain.numbergenerator.RandomNumberGenerator
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
    private val inputView : InputView,
    private val outputView: OutputView,
) {
    fun start(){
        outputView.printGameStart()
        var startOrQuit = START
        while(startOrQuit == START){
            run()
            startOrQuit = inputView.readStartOrQuit()
        }
    }
    private fun run(){
        val opponentNumber = BaseballNumbers(RandomNumberGenerator().generateNumber()).baseballNumbers
        var answer = getPlayerAnswer()
        while(opponentNumber != answer) {
            val (ball, strike) = Judgement().judgeNumber(opponentNumber, answer)
            outputView.printResultOfInning(ball, strike)
            answer = getPlayerAnswer()
        }
        outputView.printResultOfBaseBall()
    }

    private fun getPlayerAnswer(): List<BaseballNumber> {
        return runCatching {
            val baseballNumbers = BaseballNumbers(inputView.readAnswer())
            return baseballNumbers.baseballNumbers
        }.onFailure { e ->
            println(e.message)
        }.getOrElse { getPlayerAnswer() }
    }

    companion object {
        private const val START = 1
    }
}