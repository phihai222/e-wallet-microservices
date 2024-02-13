package com.phihai91.bankservice.adapter.out.persistence.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.port.`in`.account.command.CreateAccountCommand
import com.phihai91.bankservice.application.port.out.account.ICreateAccountPort
import com.phihai91.bankservice.application.port.out.account.ILoadAccountPort
import com.phihai91.bankservice.common.anotations.PersistenceAdapter

@PersistenceAdapter
class AccountPersistentAdapter: ILoadAccountPort, ICreateAccountPort {
    override fun createAccount(command: CreateAccountCommand): Account {
        TODO("Not yet implemented")
    }

    override fun existedAccountByMobileNumber(mobileNumber: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun loadAccountById(id: String): Account {
        TODO("Not yet implemented")
    }
}