package com.phihai91.bankservice.application.domain.service

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.IGetIntegratorUseCase
import com.phihai91.bankservice.application.port.out.ILoadIntegratorPort
import com.phihai91.bankservice.common.anotations.UseCase
import org.springframework.beans.factory.annotation.Autowired

@UseCase
class GetIntegratorService : IGetIntegratorUseCase {
    @Autowired
    private lateinit var loadIntegratorPort: ILoadIntegratorPort

    override fun getIntegrator(id: String): Integrator {
        return loadIntegratorPort.loadIntegratorById(id)
    }
}