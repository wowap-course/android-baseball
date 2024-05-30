package baseball.domain

class Judgment {
    fun judgeScore(baseNumbers: BaseballNumbers, targetNumbers: BaseballNumbers) = BaseballScore(
        strike = judgeStrikeCount(baseNumbers, targetNumbers),
        ball = judgeBallCount(baseNumbers, targetNumbers),
    )

    private fun judgeStrikeCount(baseNumbers: BaseballNumbers, targetNumbers: BaseballNumbers): Int {
        return (0..<BaseballNumbers.NUMBERS_SIZE).count { baseNumbers[it] == targetNumbers[it] }
    }

    private fun judgeBallCount(baseNumbers: BaseballNumbers, targetNumbers: BaseballNumbers): Int {
        return targetNumbers.numbers.count { it in baseNumbers.numbers } - judgeStrikeCount(baseNumbers, targetNumbers)
    }
}
