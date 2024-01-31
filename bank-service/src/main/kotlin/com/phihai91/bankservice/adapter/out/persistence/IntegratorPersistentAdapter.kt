package com.phihai91.bankservice.adapter.out.persistence

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.Status
import com.phihai91.bankservice.application.port.out.LoadIntegratorPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class IntegratorPersistentAdapter : LoadIntegratorPort {
    @Autowired
    private lateinit var integratorRepository: IntegratorRepository
    override fun loadIntegratorById(id: String): Integrator {
        val integrator = integratorRepository.getIntegratorById(id)

        // TODO check null throw exception and convert to HTTP response

        return Integrator(
                integrator.id,
                integrator.apiKey,
                integrator.expiredAt,
                Status.valueOf(integrator.status))
    }
}