package com.example.baseball.presentation.main

interface MainContract {
    interface View {
        fun showLife(life: Int)
        fun navigateToGameActivity(life: Int)
    }

    interface Presenter {
        fun increaseLife()
        fun decreaseLife()
        fun onGameStartBtnClicked()
    }
}