package com.phihai91.bankservice.application.domain.model

data class Account(
    val accountNumber: String,
    val mobileNumber: String,
    val passcode: String,
    val accountType: AccountType,
    val balanceBaseline: Long,
    val walletConnected: Boolean,
    val status: Status,
    val createdAt: Long,
)

enum class AccountType {
    COMPANY,
    INDIVIDUAL
}
