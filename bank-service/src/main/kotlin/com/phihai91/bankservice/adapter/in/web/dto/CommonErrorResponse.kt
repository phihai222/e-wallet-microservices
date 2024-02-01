package com.phihai91.bankservice.adapter.`in`.web.dto

import java.util.*

data class CommonErrorResponse(
        val message: String,
        val timestamp: Long =  Date().time,
)
