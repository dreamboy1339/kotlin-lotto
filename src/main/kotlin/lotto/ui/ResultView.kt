package lotto.ui

import lotto.domain.LottoDispenser
import lotto.domain.LottoStatics
import lotto.domain.WinningResult
import lotto.domain.model.Rank

class ResultView {

    fun showPurchaseResult(lottoDispenser: LottoDispenser) {
        println("수동으로 ${lottoDispenser.manualLottoList.size}장, 자동으로 ${lottoDispenser.autoLottoList.size}개를 구매했습니다.")
        lottoDispenser.lottoList.forEach { println(it) }
    }

    fun showResult(dispenser: LottoDispenser) {
        println("\n당첨 통계")
        println("---------")

        val statics = LottoStatics(dispenser.ranks)
        val earningRate = statics.calculateEarningRate(statics.totalReward, dispenser.amount)

        printRankPrize(statics.winningResult)

        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }

    private fun printRankPrize(winningResult: WinningResult) {
        Rank.values().forEach { rank: Rank ->
            if (rank == Rank.NO_MATCH) return@forEach

            val count = winningResult.getOrDefault(rank, 0)

            val matchCountString = "${rank.matchCount}개 일치"
            val matchPrizeString = "(${rank.prize}원)- ${count}개"

            val text = if (rank == Rank.SECOND_GRADE) {
                "$matchCountString, 보너스 볼 일치$matchPrizeString"
            } else {
                "$matchCountString $matchPrizeString"
            }

            println(text)
        }
    }
}
