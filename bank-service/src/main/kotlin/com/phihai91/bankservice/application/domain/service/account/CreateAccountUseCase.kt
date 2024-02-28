package com.phihai91.bankservice.application.domain.service.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.domain.model.AccountType
import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.Status
import com.phihai91.bankservice.application.port.`in`.account.ICreateAccountUseCase
import com.phihai91.bankservice.application.port.`in`.account.command.CreateAccountCommand
import com.phihai91.bankservice.application.port.out.account.ICreateAccountPort
import com.phihai91.bankservice.application.port.out.account.ILoadAccountPort
import com.phihai91.bankservice.common.anotations.UseCase
import com.phihai91.bankservice.common.exception.ConflictException
import com.phihai91.bankservice.common.exception.ForbiddenException
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@UseCase
class CreateAccountUseCase : ICreateAccountUseCase {
    @Autowired
    private lateinit var loadAccountPort: ILoadAccountPort

    @Autowired
    private lateinit var createAccountPort: ICreateAccountPort

    override fun createAccount(command: CreateAccountCommand, caller: Integrator): Account {
        if (!caller.isAdmin()) throw ForbiddenException()

        val existedAccount = loadAccountPort.existedAccountByMobileNumber(command.mobileNumber)
        if (existedAccount) throw ConflictException()

        val newAccount = command.let {
            Account(
                accountNumber = Date().time.toString(),
                mobileNumber = it.mobileNumber,
                passcode = it.passcode,
                accountType = AccountType.INDIVIDUAL,
                balanceBaseline = 1000000L,
                walletConnected = false,
                status = Status.ACTIVE,
                createdAt = Date().time
            )
        }

        return createAccountPort.createAccount(newAccount)
    }
}