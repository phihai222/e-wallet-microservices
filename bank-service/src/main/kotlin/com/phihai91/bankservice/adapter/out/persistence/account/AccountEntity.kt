package com.phihai91.bankservice.adapter.out.persistence.account

import com.phihai91.bankservice.application.domain.model.Status

data class AccountEntity(
    val accountNumber: String,
    val mobileNumber: String,
    val passcode: String,
    val accountType: String,
    val balanceBaseline: Long,
    val walletConnected: Boolean,
    val status: Status,
    val createdAt: Long,
)
