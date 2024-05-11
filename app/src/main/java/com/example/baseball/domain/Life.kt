package com.example.baseball.domain

data class Life(val life:Int) {
    init{
        require(life in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }
    fun increase():Life{
        if(life == 10) return this
        return Life(life+1)
    }
    fun decrease():Life{
        if(life == 1) return this
        return Life(life - 1)
    }
    companion object{
        private val MIN_LIFE_COUNT = 1
        private val MAX_LIFE_COUNT = 10
    }

}