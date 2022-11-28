package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class LottoStatics(private val winners: List<Winner> = emptyList()) {

    private val earningRateFormat = DecimalFormat("#.##").apply {
        roundingMode = RoundingMode.DOWN
    }

    val totalReward: Int = calculateTotalReward()

    val winningResult: WinningResult = calculateWinningCount()

    private fun calculateTotalReward(): Int {
        var total = 0
        winners.forEach { winner ->
            total += winner.prize
        }
        return total
    }

    private fun calculateWinningCount(): WinningResult {
        val result = WinningResult()
        winners.forEach { winner ->
            when (winner) {
                Winner.FIRST_GRADE -> result.numberOfFirstGrade++
                Winner.SECOND_GRADE -> result.numberOfSecondGrade++
                Winner.THIRD_GRADE -> result.numberOfThirdGrade++
                Winner.FOURTH_GRADE -> result.numberOfFourthGrade++
                Winner.FIVE_GRADE,
                Winner.SIX_GRADE,
                Winner.NO_MATCH -> Unit
            }
        }
        return result
    }

    fun calculateEarningRate(prize: Int, amount: Int): Float {
        val quotient = prize.toFloat().div(amount.toFloat())
        return earningRateFormat.format(quotient).toFloat()
    }
}
