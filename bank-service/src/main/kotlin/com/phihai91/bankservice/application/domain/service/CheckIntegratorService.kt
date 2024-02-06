package com.phihai91.bankservice.application.domain.service

import com.phihai91.bankservice.application.port.`in`.ICheckValidIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.IGetIntegratorUseCase
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