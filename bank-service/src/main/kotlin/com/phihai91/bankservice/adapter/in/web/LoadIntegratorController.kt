package com.phihai91.bankservice.adapter.`in`.web

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.GetIntegratorUseCase
import com.phihai91.bankservice.common.WebAdapter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@RequestMapping("/api/v1/integrator")
class LoadIntegratorController {
    @Autowired
    private lateinit var getIntegratorUseCase: GetIntegratorUseCase

    @GetMapping("/{id}")
    fun getIntegrator(@PathVariable("id") id: String) : Mono<Integrator> {
        return Mono.just(getIntegratorUseCase.getIntegrator(id))
    }
}