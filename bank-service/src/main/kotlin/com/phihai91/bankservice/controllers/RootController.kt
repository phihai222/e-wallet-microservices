package com.phihai91.bankservice.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("api/v1")
class RootController {

    @GetMapping("/ping")
    fun ping() : Mono<Long> {
        return Mono.just(Date().time)
    }
}