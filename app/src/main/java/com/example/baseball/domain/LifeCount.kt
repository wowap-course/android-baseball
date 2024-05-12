package com.example.baseball.domain

data class LifeCount(private var _lifeCount : Int = 1) {
    init {
        require(_lifeCount in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }
    val lifeCount : String
        get() = _lifeCount.toString()

    fun increase() : String {
        if(_lifeCount < 99) _lifeCount++
        return lifeCount
    }

    fun decrease() : String {
        if(_lifeCount > 1) _lifeCount--
        return lifeCount
    }
    companion object {
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 99
    }
}