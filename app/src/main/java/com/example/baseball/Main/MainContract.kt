package com.example.baseball.Main

interface MainContract {
    interface View{
        fun showLife(life:Int)
        fun startGamePage(life:Int)
    }

    interface Presenter{
        fun startGame()
    }
}