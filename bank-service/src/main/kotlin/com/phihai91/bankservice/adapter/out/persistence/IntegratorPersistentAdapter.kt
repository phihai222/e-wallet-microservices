package com.phihai91.bankservice.adapter.out.persistence

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.Status
import com.phihai91.bankservice.application.port.out.ICreateIntegratorPort
import com.phihai91.bankservice.application.port.out.ILoadIntegratorPort
import com.phihai91.bankservice.common.PersistenceAdapter
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired

@PersistenceAdapter
class IntegratorPersistentAdapter : ILoadIntegratorPort, ICreateIntegratorPort {
    @Autowired
    private lateinit var integratorRepository: IntegratorRepository
    override fun loadIntegratorById(id: String): Integrator {
        val integrator = integratorRepository.getIntegratorById(id) ?:
        throw EntityNotFoundException("Integrator not found with id: $id")

        return Integrator(
                id =  integrator.id,
                apiKey = integrator.apiKey,
                expireTime =  integrator.expiredAt,
                createAt =  integrator.createdAt,
                status = Status.valueOf(integrator.status),
                name = integrator.serviceName)
    }

    override fun create(integrator: Integrator): Integrator {
        val entity = IntegratorEntity(
                id = integrator.id,
                serviceName = integrator.name,
                apiKey = integrator.apiKey,
                createdAt = integrator.createAt,
                expiredAt = integrator.expireTime,
                status = integrator.status.toString()
        )

        integratorRepository.save(entity)

        val responseEntity = integratorRepository.getIntegratorById(integrator.id) ?:
        throw EntityNotFoundException("Integrator not found with id: ${integrator.id}")

        // TODO create a mapper from entity to domain

        return responseEntity.let{
            Integrator(
                    id = it.id,
                    createAt = it.createdAt,
                    apiKey = it.apiKey,
                    status = Status.valueOf(it.status),
                    name = it.serviceName,
                    expireTime = it.expiredAt)
        }
    }
}