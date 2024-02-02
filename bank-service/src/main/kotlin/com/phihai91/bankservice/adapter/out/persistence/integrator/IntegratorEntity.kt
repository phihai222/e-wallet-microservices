package com.phihai91.bankservice.adapter.out.persistence.integrator

data class IntegratorEntity(
        val id: String,
        val apiKey: String,
        val serviceName: String,
        var status: String,
        val createdAt: Long,
        val expiredAt: Long,
)
