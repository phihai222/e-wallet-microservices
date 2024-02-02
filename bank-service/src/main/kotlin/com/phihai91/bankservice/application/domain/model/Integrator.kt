package com.phihai91.bankservice.application.domain.model

class Integrator(
        val id: String,
        val apiKey: String,
        val name: String,
        val expireTime: Long,
        val createAt: Long,
        val status: Status,
) {
//    val isExpired = Date().time - expireTime > 0
//    val isDeactivate = status == Status.DEACTIVE
}