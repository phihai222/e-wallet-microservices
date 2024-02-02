package com.phihai91.bankservice.application.port.out

import com.phihai91.bankservice.application.domain.model.Integrator

interface ILoadIntegratorPort {
    fun loadIntegratorById(id:String) : Integrator
}