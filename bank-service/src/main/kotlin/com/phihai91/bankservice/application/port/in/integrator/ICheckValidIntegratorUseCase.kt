package com.phihai91.bankservice.application.port.`in`.integrator

interface ICheckValidIntegratorUseCase {
    fun checkValidIntegrator(apiKey: String) : Boolean
}