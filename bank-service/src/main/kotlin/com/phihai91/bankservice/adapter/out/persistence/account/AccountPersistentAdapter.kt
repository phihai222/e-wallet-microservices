package com.phihai91.bankservice.adapter.out.persistence.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.domain.model.AccountType
import com.phihai91.bankservice.application.port.out.account.ICreateAccountPort
import com.phihai91.bankservice.application.port.out.account.ILoadAccountPort
import com.phihai91.bankservice.common.anotations.PersistenceAdapter
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired

@PersistenceAdapter
class AccountPersistentAdapter : ILoadAccountPort, ICreateAccountPort {
    @Autowired
    private lateinit var accountRepository: AccountRepository
    override fun existedAccountByMobileNumber(mobileNumber: String): Boolean {
        return accountRepository.existedByMobileNumber(mobileNumber)
    }

    override fun loadAccountById(accountNumber: String): Account {
        val account = accountRepository.findByAccountNumber(accountNumber) ?: throw EntityNotFoundException()

        return account.let {
            Account(
                accountNumber = it.accountNumber,
                accountType = AccountType.valueOf(it.accountType),
                walletConnected = it.walletConnected,
                status = it.status,
                mobileNumber = it.mobileNumber,
                balanceBaseline = it.balanceBaseline,
                createdAt = it.createdAt,
                passcode = it.passcode
            )
        }
    }

    override fun createAccount(account: Account): Account {
        val newAccountEntity = account.let {
            AccountEntity(
                accountNumber = it.accountNumber,
                mobileNumber = it.mobileNumber,
                passcode = it.passcode,
                accountType = it.accountType.toString(),
                balanceBaseline = it.balanceBaseline,
                walletConnected = it.walletConnected,
                status = it.status,
                createdAt = it.createdAt
            )
        }

        accountRepository.saveAccount(newAccountEntity)

        return loadAccountById(newAccountEntity.accountNumber)
    }
}