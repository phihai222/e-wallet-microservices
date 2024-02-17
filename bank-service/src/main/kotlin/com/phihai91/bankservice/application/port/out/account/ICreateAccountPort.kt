package com.phihai91.bankservice.application.port.out.account

import com.phihai91.bankservice.application.domain.model.Account

interface ICreateAccountPort {
    fun createAccount(account: Account) : Account
}