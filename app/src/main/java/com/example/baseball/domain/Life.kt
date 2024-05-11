package com.example.baseball.domain

data class Life(var life: Int) {
    init {
        require(life in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }

    fun increase(): Int {
        if (life == 10) return life
        return life++
    }

    fun decrease(): Int {
        if (life == 1) return life
        return life--
    }

    companion object {
        private val MIN_LIFE_COUNT = 1
        private val MAX_LIFE_COUNT = 10
    }

}