package com.example.baseball.Game

interface GameContract {
    interface View{
        fun showResult(strikeCount: Int, ballCount: Int, lifeCount: Int)

    }

    interface Presenter{
        fun randomNumberGenerator() : List<Int>
        fun game(randomNumber:List<Int>, inputNumber: List<Int>, lifeCount: Int?)
    }
}