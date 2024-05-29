package com.example.baseball.displayBoard

data class BoardItems(val trytime: Int, val strike: Int, val ball: Int, val answer: List<Int>) {
    override fun toString(): String {
        return answer.joinToString(", ")
    }
}
