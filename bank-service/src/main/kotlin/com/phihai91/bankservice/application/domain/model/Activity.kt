package com.phihai91.bankservice.application.domain.model

class Activity(
    val id: String,
    val ownerAccountId: String,
    val sourceAccountId: String,
    val targetAccountId: String,
    val money: Money,
    val createdAt: Long,
)
