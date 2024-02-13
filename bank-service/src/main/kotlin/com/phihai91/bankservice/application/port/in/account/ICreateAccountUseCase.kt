package com.phihai91.bankservice.application.port.`in`.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.port.`in`.account.command.CreateAccountCommand

interface ICreateAccountUseCase {
    fun createAccount(command: CreateAccountCommand): Account
}