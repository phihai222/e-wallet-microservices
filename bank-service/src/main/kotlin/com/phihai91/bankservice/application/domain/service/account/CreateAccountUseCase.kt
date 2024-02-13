package com.phihai91.bankservice.application.domain.service.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.port.`in`.account.ICreateAccountUseCase
import com.phihai91.bankservice.application.port.`in`.account.command.CreateAccountCommand
import com.phihai91.bankservice.application.port.out.account.ICreateAccountPort
import com.phihai91.bankservice.application.port.out.account.ILoadAccountPort
import com.phihai91.bankservice.common.anotations.UseCase
import com.phihai91.bankservice.common.exception.ConflictException
import org.springframework.beans.factory.annotation.Autowired

@UseCase
class CreateAccountUseCase : ICreateAccountUseCase {
    @Autowired
    private lateinit var loadAccountPort: ILoadAccountPort

    @Autowired
    private lateinit var createAccountPort: ICreateAccountPort

    override fun createAccount(command: CreateAccountCommand): Account {
        val existedAccount = loadAccountPort.existedAccountByMobileNumber(command.mobileNumber)
        if(existedAccount) throw ConflictException()

        return createAccountPort.createAccount(command)
    }
}