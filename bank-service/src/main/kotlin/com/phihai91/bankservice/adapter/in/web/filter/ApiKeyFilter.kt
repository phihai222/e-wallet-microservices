package com.phihai91.bankservice.adapter.`in`.web.filter

import com.phihai91.bankservice.application.port.`in`.integrator.ICheckValidIntegratorUseCase
import com.phihai91.bankservice.common.API_KEY
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.server.PathContainer
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import org.springframework.web.util.pattern.PathPattern
import org.springframework.web.util.pattern.PathPatternParser
import reactor.core.publisher.Mono

@Component
class ApiKeyFilter : WebFilter {
    @Autowired
    private lateinit var checkValidIntegratorUseCase: ICheckValidIntegratorUseCase
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        if (isPublic(exchange.request.path.value()))
            return chain.filter(exchange)

        val res = resolveApiKey(exchange.request)

        if (!res)
            return Mono.error(ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Api Key"))

        return chain.filter(exchange)
    }

    fun resolveApiKey(request: ServerHttpRequest): Boolean {
        val headerApiKey = request.headers.getFirst(API_KEY)
                ?: return false

        return try {
            checkValidIntegratorUseCase.checkValidIntegrator(headerApiKey)
        } catch (ex: EntityNotFoundException) {
            false
        }
    }

    fun isPublic(path: String): Boolean {
        val publicPath = listOf("/api/v1/public/**",
                "/swagger-ui.html",
                "/webjars/swagger-ui/**",
                "/v3/api-docs/swagger-config",
                "/v3/api-docs")

        val patters = mutableListOf<PathPattern>()

        publicPath.forEach {
            patters.add(PathPatternParser.defaultInstance.parse(it))
        }

        patters.forEach {
            if (it.matches(PathContainer.parsePath(path)))
                return true
        }

        return false
    }
}