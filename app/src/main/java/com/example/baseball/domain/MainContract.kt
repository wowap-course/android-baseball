package com.example.baseball.domain

interface MainContract {

    interface View {
        fun showLife(life: Int)
    }

    interface Presenter {
        fun increaseLife()
        fun decreaseLife()
    }
}