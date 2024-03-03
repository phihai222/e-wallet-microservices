package com.phihai91.bankservice.application.domain.model

class Money(
    val amount: ULong
) {
    fun isGreaterThan(money: Money) : Boolean {
        return amount.compareTo(money.amount) >= 1
    }
}
