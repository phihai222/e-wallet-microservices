package com.phihai91.bankservice.application.port.`in`

import com.phihai91.bankservice.application.domain.model.Integrator

interface IGetIntegratorUseCase {
    fun getIntegrator(id: String) : Integrator
}