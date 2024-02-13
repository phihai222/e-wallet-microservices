package com.phihai91.bankservice.application.port.`in`.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.integrator.command.CreateIntegratorCommand

interface ICreateIntegratorUseCase {
    fun createIntegrator(command: CreateIntegratorCommand, caller: Integrator) : Integrator
}
