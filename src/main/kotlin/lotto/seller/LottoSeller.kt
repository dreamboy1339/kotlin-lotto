package lotto.seller

import lotto.agency.LottoTicket
import lotto.exception.MinimumPurchaseMoneyException

class LottoSeller {

    fun calculateLottoPurchaseAmount(money: Int): Int {
        validatePurchaseMoney(money)
        return money / LOTTO_PURCHASE_PRICE_PER_PIECE
    }

    fun sell(amount: Int): List<LottoTicket> {
        val purchaseLottoTickets = mutableListOf<LottoTicket>()
        repeat(amount) {
            purchaseLottoTickets.add(LottoTicket())
        }

        return purchaseLottoTickets
    }

    private fun validatePurchaseMoney(money: Int) {
        if (money < LOTTO_PURCHASE_PRICE_PER_PIECE) {
            throw MinimumPurchaseMoneyException("최소 ${LOTTO_PURCHASE_PRICE_PER_PIECE}원 이상 지불하셔야 로또 구매가 가능합니다.")
        }
    }

    companion object {
        const val LOTTO_PURCHASE_PRICE_PER_PIECE = 1_000
    }
}
