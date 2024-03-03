package com.phihai91.bankservice.application.port.`in`.activity

import com.phihai91.bankservice.application.port.`in`.activity.command.TransferMoneyCommand

interface ITransferMoneyUseCase {
    fun transferMoney(command: TransferMoneyCommand): Boolean
}