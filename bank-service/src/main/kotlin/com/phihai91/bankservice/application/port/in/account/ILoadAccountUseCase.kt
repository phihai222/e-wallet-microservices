package com.phihai91.bankservice.application.port.`in`.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.domain.model.Integrator

interface ILoadAccountUseCase {
    fun loadAllAccount(caller: Integrator): List<Account>
}