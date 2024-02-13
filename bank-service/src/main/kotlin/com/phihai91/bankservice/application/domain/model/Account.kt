package com.phihai91.bankservice.application.domain.model

data class Account(
    val accountNumber: String,
    val mobileNumber: String,
    val passcode: String,
    val accountType: String,
    val balanceBaseline: Long,
    val walletConnected: Boolean,
    val status: Status,
    val createdAt: Long,
)
