package com.phihai91.bankservice.application.port.out.integrator

import com.phihai91.bankservice.application.domain.model.Integrator

interface ILoadIntegratorPort {
    fun loadIntegratorById(id: String): Integrator
    fun loadIntegratorByApiKey(apiKey: String): Integrator
}