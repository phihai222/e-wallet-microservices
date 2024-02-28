package com.phihai91.bankservice.adapter.`in`.web.controller.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.domain.service.account.CreateAccountUseCase
import com.phihai91.bankservice.application.port.`in`.account.command.CreateAccountCommand
import com.phihai91.bankservice.application.port.`in`.integrator.IGetIntegratorUseCase
import com.phihai91.bankservice.common.API_KEY
import com.phihai91.bankservice.common.anotations.WebAdapter
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@WebAdapter
@RestController
@RequestMapping("/api/v1/account")
@SecurityRequirement(name = "apiKey")
@Tag(name = "Account")
class CreateAccountController {
    @Autowired
    private lateinit var createAccountUseCase: CreateAccountUseCase

    @Autowired
    lateinit var getIntegratorUseCase: IGetIntegratorUseCase

    @PostMapping
    fun createAccount(
        @RequestBody input: CreateAccountCommand,
        @Parameter(required = false, hidden = true) @RequestHeader(API_KEY) apiKey: String
    ): ResponseEntity<Mono<Account>> {
        val integrator = getIntegratorUseCase.getIntegratorByKey(apiKey)

        return createAccountUseCase.createAccount(input,integrator).let {
            ResponseEntity.ok(Mono.just(it))
        }
    }
}