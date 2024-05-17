package com.example.baseball.Game

interface GameContract {
    interface View{
        fun showResult(strikeCount: Int, ballCount: Int)

    }
}