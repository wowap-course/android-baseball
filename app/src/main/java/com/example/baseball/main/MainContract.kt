package com.example.baseball.main

interface MainContract {
    interface View{
        fun showLife(life:Int)
        fun startGamePage(life:Int)
    }

    interface Presenter{
        fun increaseLife()
        fun decreaseLife()
        fun startGame()
    }
}
