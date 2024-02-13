package com.phihai91.bankservice.application.port.`in`

import com.phihai91.bankservice.application.domain.model.Integrator

interface IGetIntegratorUseCase {
    fun getIntegratorById(id: String, current: Integrator): Integrator
    fun getIntegratorByKey(apiKey: String): Integrator
}