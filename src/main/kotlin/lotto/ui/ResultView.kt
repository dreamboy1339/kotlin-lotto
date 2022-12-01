package lotto.ui

import lotto.domain.*

class ResultView {

    private lateinit var winners: List<Winner>
    private var bonusNumber: String = ""
    private var winningNumbers: String = ""

    fun inputWinningNumbers() {
        println("")
        println("지난 주 당첨 번호를 입력해 주세요.")
        winningNumbers = readLine() ?: ""
        val isLottoNumbers = LottoNumberValidator.validate(winningNumbers)
        return if (isLottoNumbers) {
            inputBonusNumber()
        } else {
            inputWinningNumbers()
        }
    }

    private fun inputBonusNumber() {
        println("보너스 볼을 입력해 주세요.")
        bonusNumber = readLine() ?: ""
        val isBonusNumber = LottoNumberValidator.validateBonus(bonusNumber)
        return if (isBonusNumber) {
            return
        } else {
            bonusNumber = ""
            inputBonusNumber()
        }
    }

    fun checkWinningLottoList(lottoList: List<Lotto>) {
        winners = lottoList.map { lotto ->
            WinningChecker.win(winningNumbers, lotto.numbers)
        }
    }

    fun showResult(amount: Int) {
        println("\n당첨 통계")
        println("---------")

        val statics = LottoStatics(winners)
        val earningRate = statics.calculateEarningRate(statics.totalReward, amount)
        val winningResult = statics.winningResult

        println("3개 일치 (5000원)- ${winningResult.numberOfFifthGrade}개")
        println("4개 일치 (50000원)- ${winningResult.numberOfFourthGrade}개")
        println("5개 일치 (1500000원)- ${winningResult.numberOfThirdGrade}개")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${winningResult.numberOfSecondGrade}개")
        println("6개 일치 (2000000000원)- ${winningResult.numberOfFirstGrade}개")
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
