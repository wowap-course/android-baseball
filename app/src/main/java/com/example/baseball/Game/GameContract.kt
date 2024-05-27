package com.example.baseball.Game

import Count

interface GameContract {
    interface View {

        fun showResult(counts: List<Count>)
        fun showLife(lifeCount: Int)
        fun showWinDialog(randomNumber: List<Int>)
        fun showLoseDialog(randomNumber: List<Int>)

    }

    interface Presenter {
        fun randomNumberGenerator(): List<Int>
        fun game(inputNumber: List<Int>)
    }
}
