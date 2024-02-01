package com.phihai91.bankservice.application.domain.service

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.GetIntegratorUseCase
import com.phihai91.bankservice.application.port.out.LoadIntegratorPort
import com.phihai91.bankservice.common.UseCase
import org.springframework.beans.factory.annotation.Autowired

@UseCase
class GetIntegratorService : GetIntegratorUseCase {
    @Autowired
    private lateinit var loadIntegratorPort: LoadIntegratorPort

    override fun getIntegrator(id: String): Integrator {
        return loadIntegratorPort.loadIntegratorById(id)
    }
}