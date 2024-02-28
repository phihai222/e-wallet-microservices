package com.phihai91.bankservice.adapter.`in`.web.controller.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.integrator.IGetIntegratorUseCase
import com.phihai91.bankservice.common.API_KEY
import com.phihai91.bankservice.common.anotations.WebAdapter
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@RequestMapping("/api/v1/integrator")
@SecurityRequirement(name = "apiKey")
@Tag(name = "Integrator")
class LoadIntegratorController {
    @Autowired
    private lateinit var getIntegratorUseCase: IGetIntegratorUseCase

    @GetMapping("/{id}")
    fun getIntegrator(
        @PathVariable("id") id: String,
        @Parameter(required = false, hidden = true) @RequestHeader(API_KEY) apiKey: String
    ) : Mono<Integrator>
    {
        val currentIntegrator = getIntegratorUseCase.getIntegratorByKey(apiKey)
        return Mono.just(getIntegratorUseCase.getIntegratorById(id, currentIntegrator))
    }
}