package com.example.baseball.presentation.main

interface MainContract {

    interface View {
        fun showLife(life: Int)
        fun navigateToGame(life: Int)
    }

    interface Presenter {
        fun increaseLife()
        fun decreaseLife()
        fun gameStart()
    }
}

