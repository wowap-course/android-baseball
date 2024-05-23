package com.example.baseball.domain.numberRules

import com.example.baseball.domain.Referee.Companion.MAX_COM_NUMBER_SIZE
import com.example.baseball.domain.Referee.Companion.MAX_RANDOM_NUMBER
import com.example.baseball.domain.Referee.Companion.MIN_RANDOM_NUMBER
import com.example.baseball.domain.contracts.ComputerGenerateNumberRule

class ThreeRandomNumberGenerator : ComputerGenerateNumberRule {
    override fun generateNumber(): List<Int> {
        val randomNumbers = mutableListOf<Int>()

        while (randomNumbers.size < MAX_COM_NUMBER_SIZE) {
            val randomNumber = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber)
            }
        }

        println(randomNumbers)
        return randomNumbers
    }
}