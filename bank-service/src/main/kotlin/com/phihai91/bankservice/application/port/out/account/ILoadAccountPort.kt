package com.phihai91.bankservice.application.port.out.account

import com.phihai91.bankservice.application.domain.model.Account

interface ILoadAccountPort {
    fun existedAccountByMobileNumber(mobileNumber: String) : Boolean
    fun loadAccountById(accountNumber: String) : Account
    fun loadAccounts() : List<Account>
}