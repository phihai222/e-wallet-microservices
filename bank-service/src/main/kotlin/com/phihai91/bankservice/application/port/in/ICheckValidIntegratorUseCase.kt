package com.phihai91.bankservice.application.port.`in`

interface ICheckValidIntegratorUseCase {
    fun checkValidIntegrator(apiKey: String) : Boolean
}