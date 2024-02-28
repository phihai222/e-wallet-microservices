package com.phihai91.bankservice.application.domain.service.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.account.ILoadAccountUseCase
import com.phihai91.bankservice.application.port.out.account.ILoadAccountPort
import com.phihai91.bankservice.common.anotations.UseCase
import com.phihai91.bankservice.common.exception.ConflictException
import org.springframework.beans.factory.annotation.Autowired

@UseCase
class LoadAccountUseCase: ILoadAccountUseCase {
    @Autowired
    private lateinit var loadAccountPort: ILoadAccountPort

    override fun loadAllAccount(caller: Integrator): List<Account> {
        if(!caller.isAdmin()) throw ConflictException()
        return loadAccountPort.loadAccounts()
    }
}