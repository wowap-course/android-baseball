package com.example.baseball.presentation.game

interface GameContract {
    interface View {
        fun showResultOfInning(ball: Int, strike: Int)
        fun showResultOfGame(resultOfGame: String, correctAnswer: Int)
        fun showLifeCount(lifeCount : Int)
    }

    interface Presenter {
        fun playOneRound(answer: String)
    }
}