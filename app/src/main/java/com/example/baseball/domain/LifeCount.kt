package com.example.baseball.domain

data class LifeCount(private var _count : Int = 1) {
    init {
        require(_count in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }
    val count : Int
        get() = _count

    fun increase() : Int {
        if(_count < MAX_LIFE_COUNT) _count++
        return count
    }

    fun decrease() : Int {
        if(_count > MIN_LIFE_COUNT) _count--
        return count
    }
    companion object {
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 19
    }
}