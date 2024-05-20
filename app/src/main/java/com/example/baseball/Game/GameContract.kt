package com.example.baseball.Game

interface GameContract {
    interface View{
        fun showResult(strikeCount: Int, ballCount: Int, lifeCount: Int)
        fun showWinDialog(randomNumber: List<Int>)
        fun showLoseDialog(randomNumber: List<Int>)

    }

    interface Presenter{
        fun randomNumberGenerator() : List<Int>
        fun game(randomNumber:List<Int>, inputNumber: List<Int>, lifeCount: Int?)
    }
}