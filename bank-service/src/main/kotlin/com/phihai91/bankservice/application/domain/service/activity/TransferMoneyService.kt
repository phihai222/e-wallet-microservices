package com.phihai91.bankservice.application.domain.service.activity

import com.phihai91.bankservice.application.domain.model.Money
import com.phihai91.bankservice.application.port.`in`.activity.ITransferMoneyUseCase
import com.phihai91.bankservice.application.port.`in`.activity.command.TransferMoneyCommand
import com.phihai91.bankservice.common.anotations.UseCase

@UseCase
class TransferMoneyService: ITransferMoneyUseCase  {
    val maximumTransferThreshold: Money = Money(amount = 1_000_000u)

    override fun transferMoney(command: TransferMoneyCommand): Boolean {
        checkThreshold(command)
        TODO("Not yet implemented")
    }

    fun checkThreshold(command: TransferMoneyCommand) {
        if(command.money.isGreaterThan(maximumTransferThreshold)) {
            throw ThresholdExceededException("Maximum threshold for transferring money exceeded ${maximumTransferThreshold.amount}")
        }
    }
}