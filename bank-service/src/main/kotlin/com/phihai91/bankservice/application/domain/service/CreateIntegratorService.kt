package com.phihai91.bankservice.application.domain.service

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.IntegratorType
import com.phihai91.bankservice.application.domain.model.Status
import com.phihai91.bankservice.application.port.`in`.ICreateIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.command.CreateIntegratorCommand
import com.phihai91.bankservice.application.port.out.ICreateIntegratorPort
import com.phihai91.bankservice.common.anotations.UseCase
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

        val currentDate = Date()
        val calendar = Calendar.getInstance()
        calendar.setTime(currentDate)
        calendar.add(Calendar.DATE, 30)

        // TODO check current is Admin for create new Integrator

        val newIntegrator = Integrator(
                id = UUID.randomUUID().toString(),
                createAt = currentDate.time,
                apiKey = apiKey,
                name = command.name,
                expireTime = calendar.timeInMillis,
                status = Status.ACTIVE,
                type = IntegratorType.CLIENT
        )

        return createIntegratorPort.create(newIntegrator)
    }
}