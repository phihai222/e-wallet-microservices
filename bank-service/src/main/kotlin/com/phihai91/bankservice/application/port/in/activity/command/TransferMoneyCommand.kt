package com.phihai91.bankservice.application.port.`in`.activity.command

import com.phihai91.bankservice.application.domain.model.Money
import com.phihai91.bankservice.common.validate
import jakarta.validation.constraints.NotEmpty

data class TransferMoneyCommand(
    @field:NotEmpty val sourceAccountId: String,
    @field:NotEmpty val targetAccountId: String,
    val money: Money
) {
    init {
        validate(this)
    }
}
