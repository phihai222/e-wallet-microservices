package com.phihai91.bankservice.adapter.`in`.web

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.IGetIntegratorUseCase
import com.phihai91.bankservice.common.WebAdapter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@RequestMapping("/api/v1/integrator")
@Tag(name = "Integrator")
class LoadIntegratorController {
    @Autowired
    private lateinit var getIntegratorUseCase: IGetIntegratorUseCase

    @GetMapping("/{id}")
    fun getIntegrator(@PathVariable("id") id: String) : Mono<Integrator> {
        return Mono.just(getIntegratorUseCase.getIntegrator(id))
    }
}