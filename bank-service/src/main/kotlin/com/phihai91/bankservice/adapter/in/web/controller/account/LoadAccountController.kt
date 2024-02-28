package com.phihai91.bankservice.adapter.`in`.web.controller.account

import com.phihai91.bankservice.application.domain.model.Account
import com.phihai91.bankservice.application.port.`in`.account.ILoadAccountUseCase
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
@RequestMapping("/api/v1/accounts")
@SecurityRequirement(name = "apiKey")
@Tag(name = "Account")
class LoadAccountController {
    @Autowired
    lateinit var loadAccountUseCase: ILoadAccountUseCase

    @Autowired
    lateinit var getIntegratorUseCase: IGetIntegratorUseCase

    @GetMapping
    fun getAllAccount(
        @Parameter(required = false, hidden = true) @RequestHeader(API_KEY) apiKey: String
    ): ResponseEntity<Mono<List<Account>>> {
        val integrator = getIntegratorUseCase.getIntegratorByKey(apiKey)

        return loadAccountUseCase.loadAllAccount(integrator).let {
            ResponseEntity.ok(Mono.just(it))
        }
    }
}