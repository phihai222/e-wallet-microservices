package com.phihai91.bankservice.application.port.out

import com.phihai91.bankservice.application.domain.model.Integrator

interface LoadIntegratorPort {
    fun loadIntegratorById(id:String) : Integrator
}