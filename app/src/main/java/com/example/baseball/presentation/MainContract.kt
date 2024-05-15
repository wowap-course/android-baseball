package com.example.baseball.presentation

interface MainContract {

    interface View {
        fun showLife(life: Int)
    }

    interface Presenter {
        fun increaseLife()
        fun decreaseLife()
    }
}