package com.phihai91.bankservice.application.port.out

import com.phihai91.bankservice.application.domain.model.Integrator

interface ICreateIntegratorPort {
    fun create(integrator: Integrator) : Integrator
}