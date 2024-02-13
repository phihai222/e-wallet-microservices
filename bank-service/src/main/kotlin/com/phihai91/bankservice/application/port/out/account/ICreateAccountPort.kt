package com.phihai91.bankservice.application.port.out.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.port.`in`.account.command.CreateAccountCommand


interface ICreateAccountPort {
    fun createAccount(command: CreateAccountCommand) : Account
}