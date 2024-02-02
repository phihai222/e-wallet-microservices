package com.phihai91.bankservice.application.domain.service

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.Status
import com.phihai91.bankservice.application.port.`in`.ICreateIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.command.CreateIntegratorCommand
import com.phihai91.bankservice.application.port.out.ICreateIntegratorPort
import com.phihai91.bankservice.common.UseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.keygen.KeyGenerators
import java.util.*

@UseCase
class CreateIntegratorService : ICreateIntegratorUseCase {

    @Autowired
    private lateinit var createIntegratorPort: ICreateIntegratorPort

    override fun createIntegrator(command: CreateIntegratorCommand): Integrator {
        val generator = KeyGenerators.secureRandom(32)
        val key = generator.generateKey()
        val apiKey = Base64.getEncoder().encodeToString(key)

        val newIntegrator = Integrator(
                id = UUID.randomUUID().toString(),
                createAt = Date().time,
                apiKey = apiKey,
                name = command.name,
                expireTime = Date().time,
                status = Status.ACTIVE
        )

        return createIntegratorPort.create(newIntegrator)
    }
}