package com.phihai91.bankservice.adapter.`in`.web.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.port.`in`.ICreateIntegratorUseCase
import com.phihai91.bankservice.application.port.`in`.command.CreateIntegratorCommand
import com.phihai91.bankservice.common.anotations.WebAdapter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@Tag(name = "Integrator")
@RequestMapping("/api/v1/integrator")
class CreateIntegratorController {
    @Autowired
    lateinit var createIntegratorUseCase: ICreateIntegratorUseCase

    @PostMapping("")
    fun createIntegrator(@RequestBody input: CreateIntegratorCommand) : ResponseEntity<Mono<Integrator>> {
        val res = createIntegratorUseCase.createIntegrator(input)
        return ResponseEntity.ok(Mono.just(res))
    }
}