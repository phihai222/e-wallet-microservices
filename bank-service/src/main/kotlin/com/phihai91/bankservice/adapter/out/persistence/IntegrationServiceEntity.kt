package com.phihai91.bankservice.adapter.out.persistence

data class IntegrationServiceEntity(
        val id: String,
        val api_key: String,
        val created_at: Long,
        val expired_at: Long
)
