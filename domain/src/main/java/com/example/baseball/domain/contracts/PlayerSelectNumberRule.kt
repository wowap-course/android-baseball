package com.example.baseball.domain.contracts

interface PlayerSelectNumberRule {
    fun selectNumber(input: String): List<Int>
}