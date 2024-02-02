package com.phihai91.bankservice.adapter.`in`.web

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("api/v1")
@SecurityRequirement(name = "apiKey")
class RootController {
    @GetMapping("/public/ping")
    fun publicPing() : Mono<Long> {
        return Mono.just(Date().time)
    }

    @GetMapping("/secured/ping")
    fun securedPing() : Mono<Long> {
        return Mono.just(Date().time)
    }
}