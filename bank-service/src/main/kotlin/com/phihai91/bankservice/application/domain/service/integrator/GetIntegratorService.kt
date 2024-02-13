package com.phihai91.bankservice.application.domain.service.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.integrator.IGetIntegratorUseCase
import com.phihai91.bankservice.application.port.out.integrator.ILoadIntegratorPort
import com.phihai91.bankservice.common.anotations.UseCase
import com.phihai91.bankservice.common.exception.ForbiddenException
import org.springframework.beans.factory.annotation.Autowired

@UseCase
class GetIntegratorService : IGetIntegratorUseCase {
    @Autowired
    private lateinit var loadIntegratorPort: ILoadIntegratorPort

    override fun getIntegratorById(id: String, current: Integrator): Integrator {
        if (!current.isAdmin())
            throw ForbiddenException()
        return loadIntegratorPort.loadIntegratorById(id)
    }

    override fun getIntegratorByKey(apiKey: String): Integrator {
        return loadIntegratorPort.loadIntegratorByApiKey(apiKey)
    }
}