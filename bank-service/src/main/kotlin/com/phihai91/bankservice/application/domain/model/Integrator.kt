package com.phihai91.bankservice.application.domain.model

import java.util.*

class Integrator(
        val id: String? = null,
        val apiKey: String? = null,
        val expireTime: Long? = null,
        val status: Status? = null
) {
    val isExpired = Date().time - expireTime!! > 0
    val isDeactivate = status == Status.DEACTIVE
}