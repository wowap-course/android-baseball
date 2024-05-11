package com.example.baseball.domain

data class Life(val life:Int) {
    init{
        require(life in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }
    companion object{
        private val MIN_LIFE_COUNT = 1
        private val MAX_LIFE_COUNT = 10
    }

}