package com.phihai91.bankservice.application.domain.model

import java.util.*

class Integrator(
        val id: String,
        val apiKey: String,
        val name: String,
        val expireTime: Long,
        val createAt: Long,
        val status: Status,
) {
    fun isExpired(): Boolean = Date().time - expireTime <= 0
    fun isActive(): Boolean = status == Status.ACTIVE
}