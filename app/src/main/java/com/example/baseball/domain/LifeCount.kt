package com.example.baseball.domain

data class LifeCount(private var _count : Int = 1) {
    init {
        require(_count in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }
    val count : Int
        get() = _count

    fun increase() : Boolean {
        if(_count >= MAX_LIFE_COUNT) return false
        _count++
        return true
    }

    fun decrease() : Boolean {
        if(_count <= MIN_LIFE_COUNT) return false
        _count--
        return true
    }
    companion object {
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 19
    }
}