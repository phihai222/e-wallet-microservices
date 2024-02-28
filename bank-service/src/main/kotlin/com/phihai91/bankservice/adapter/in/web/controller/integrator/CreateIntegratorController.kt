package com.phihai91.bankservice.adapter.`in`.web.controller.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.integrator.ICreateIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.integrator.IGetIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.integrator.command.CreateIntegratorCommand
import com.phihai91.bankservice.common.API_KEY
import com.phihai91.bankservice.common.anotations.WebAdapter
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@RequestMapping("/api/v1/integrator")
@SecurityRequirement(name = "apiKey")
@Tag(name = "Integrator")
class CreateIntegratorController {
    @Autowired
    lateinit var createIntegratorUseCase: ICreateIntegratorUseCase

    @Autowired
    lateinit var getIntegratorUseCase: IGetIntegratorUseCase

    @PostMapping("")
    fun createIntegrator(
        @RequestBody input: CreateIntegratorCommand,
        @Parameter(required = false, hidden = true) @RequestHeader(API_KEY) apiKey: String
    ): ResponseEntity<Mono<Integrator>> {
        val integrator = getIntegratorUseCase.getIntegratorByKey(apiKey)
        val res = createIntegratorUseCase.createIntegrator(input, integrator)
        return ResponseEntity.ok(Mono.just(res))
    }
}