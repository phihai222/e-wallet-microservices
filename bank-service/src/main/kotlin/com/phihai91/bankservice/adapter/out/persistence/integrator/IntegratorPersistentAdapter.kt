package com.phihai91.bankservice.adapter.out.persistence.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.out.ICreateIntegratorPort
import com.phihai91.bankservice.application.port.out.ILoadIntegratorPort
import com.phihai91.bankservice.common.anotations.PersistenceAdapter
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired

@PersistenceAdapter
class IntegratorPersistentAdapter : ILoadIntegratorPort, ICreateIntegratorPort {
    @Autowired
    private lateinit var integratorRepository: IntegratorRepository
    override fun loadIntegratorById(id: String): Integrator {
        val integrator = integratorRepository.getIntegratorById(id) ?:
        throw EntityNotFoundException("Integrator not found with id: $id")

        return mapEntityToDomain(integrator)
    }

    override fun loadIntegratorByApiKey(apiKey: String): Integrator {
        val integrator = integratorRepository.getIntegratorByApiKey(apiKey) ?:
        throw EntityNotFoundException("Integrator not found with Key: $apiKey")
        return mapEntityToDomain(integrator)
    }

    override fun create(integrator: Integrator): Integrator {
        val entity = mapDomainToEntity(integrator)
        integratorRepository.save(entity)

        return loadIntegratorById(integrator.id)
    }
}