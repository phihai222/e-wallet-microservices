package com.phihai91.bankservice.adapter.`in`.web.filter

import com.phihai91.bankservice.common.API_KEY
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class ApiKeyFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val path = exchange.request.path
        println(path)

        // TODO add whitelist url to pass through

        val res = resolveApiKey(exchange.request)

        if (!res)
            return Mono.error(ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Api Key"))

        return chain.filter(exchange)
    }

    fun resolveApiKey(request: ServerHttpRequest): Boolean {
        val headerApiKey = request.headers.getFirst(API_KEY)

        // TODO validate valid API Key

        println(headerApiKey)

        return true
    }
}