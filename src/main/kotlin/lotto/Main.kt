package lotto

import lotto.domain.LottoDispenser
import lotto.domain.model.LottoNumber
import lotto.domain.model.Winning
import lotto.domain.model.WinningNumbers
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val inputView = InputView()

    val amount: Int = inputView.inputPurchasingAmount()
    val manualLottoCount: Int = inputView.inputManualLottoCount()
    val manualLottoNumberText: List<String> = inputView.inputManualLottoNumbers(manualLottoCount)

    val dispenser = LottoDispenser(amount, manualLottoNumberText)

    val resultView = ResultView()
    resultView.showPurchaseResult(dispenser)

    val winningNumberText: String = inputView.inputWinningNumbers()
    val bonusNumber: LottoNumber = inputView.inputBonusNumber()

    val winningNumbers: WinningNumbers = WinningNumbers.makeWinningNumbers(winningNumberText)
    dispenser.match(Winning(winningNumbers, bonusNumber))

    resultView.showResult(dispenser)
}
