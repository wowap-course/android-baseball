package com.example.baseball.presentation.game

interface GameContract {
    interface View {
        fun showResultOfInning(tryCount : Int, ball: Int, strike: Int, answer: List<Int>)
        fun showResultOfGame(resultOfGame: String, correctAnswer: Int)
        fun showLifeCount(lifeCount : Int)
        fun showRequests(msg : String)
        fun navigateToMainActivity()
        fun restartGameActivity(life : Int)
    }

    interface Presenter {
        fun onTryBtnClicked(answer: String)
        fun onRestartBtnClicked()
        fun onExitBtnClicked()
    }
}