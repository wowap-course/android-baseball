package com.example.baseball.presentation.main

import com.example.baseball.domain.LifeCount

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