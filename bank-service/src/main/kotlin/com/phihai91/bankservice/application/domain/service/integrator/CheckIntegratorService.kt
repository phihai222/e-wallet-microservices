package com.phihai91.bankservice.application.domain.service.integrator

import com.phihai91.bankservice.application.port.`in`.integrator.ICheckValidIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.integrator.IGetIntegratorUseCase
import com.phihai91.bankservice.common.anotations.UseCase
import org.springframework.beans.factory.annotation.Autowired

@UseCase
class CheckIntegratorService: ICheckValidIntegratorUseCase {
    @Autowired
    private lateinit var getIntegratorService: IGetIntegratorUseCase

    override fun checkValidIntegrator(apiKey: String): Boolean {
        val integrator = getIntegratorService.getIntegratorByKey(apiKey)
        return integrator.isActive() && integrator.isExpired()
    }
}