package com.example.baseball.domain

data class BaseballNumbers(private val _baseballNumbers : List<Int>) {
    init {
        require(!_baseballNumbers.contains(0)) { CONTAINS_ZERO_ERROR }
        require(_baseballNumbers.toSet().size == _baseballNumbers.size) { DUPLICATE_ERROR }
        require(_baseballNumbers.size == 3) { NUM_DIGITS_ERROR }
    }
    val baseballNumbers : List<BaseballNumber>
        get() = _baseballNumbers.map { BaseballNumber(it) }

    companion object {
        private const val DUPLICATE_ERROR = "[ERROR]: 중복된 숫자가 있습니다."
        private const val NUM_DIGITS_ERROR = "[ERROR]: 입력된 값은 세자리가 아닙니다."
        private const val CONTAINS_ZERO_ERROR = "[ERROR] : 0을 가질 수 없습니다."
    }
}