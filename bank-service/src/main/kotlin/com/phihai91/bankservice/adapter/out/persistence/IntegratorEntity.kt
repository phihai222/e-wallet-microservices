package com.phihai91.bankservice.adapter.out.persistence

data class IntegratorEntity(
        val id: String,
        val apiKey: String,
        val serviceName: String,
        var status: String,
        val createdAt: Long,
        val expiredAt: Long,
)
