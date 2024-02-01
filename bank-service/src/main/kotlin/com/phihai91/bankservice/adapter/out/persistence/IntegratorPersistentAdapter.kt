package com.phihai91.bankservice.adapter.out.persistence

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.Status
import com.phihai91.bankservice.application.port.out.LoadIntegratorPort
import com.phihai91.bankservice.common.PersistenceAdapter
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired

@PersistenceAdapter
class IntegratorPersistentAdapter : LoadIntegratorPort {
    @Autowired
    private lateinit var integratorRepository: IntegratorRepository
    override fun loadIntegratorById(id: String): Integrator {
        val integrator = integratorRepository.getIntegratorById(id) ?:
        throw EntityNotFoundException("Integrator not found with id: $id")

        return Integrator(
                integrator.id,
                integrator.apiKey,
                integrator.expiredAt,
                integrator.createdAt,
                Status.valueOf(integrator.status))
    }
}