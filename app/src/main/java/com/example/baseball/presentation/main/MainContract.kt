package com.example.baseball.presentation.main

interface MainContract {
    interface View {
        fun showLife(life : Int)
        fun showMaxLife()
        fun showMinLife()
    }
    interface Presenter {
        fun increaseLife()
        fun decreaseLife()
    }
}