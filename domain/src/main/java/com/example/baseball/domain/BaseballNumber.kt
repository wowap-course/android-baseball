package com.example.baseball.domain

@JvmInline
value class BaseballNumber(private val number: Int) {
    init {
        require(number in NUMBER_RANGE)
    }

    override fun toString(): String {
        return number.toString()
    }
    fun toInt() : Int {
        return number
    }
    companion object {
        private val NUMBER_RANGE = (1..9)
    }
}