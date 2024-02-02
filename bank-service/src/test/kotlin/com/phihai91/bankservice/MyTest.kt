package com.phihai91.bankservice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.server.PathContainer
import org.springframework.security.crypto.keygen.KeyGenerators
import org.springframework.web.util.pattern.PathPattern
import org.springframework.web.util.pattern.PathPatternParser
import java.util.*


@ExtendWith(MockitoExtension::class)
class MyTest {
    @Test
    fun generateKey() {
        val generator = KeyGenerators.secureRandom(32)
        val key = generator.generateKey()
        val base64 = Base64.getEncoder().encodeToString(key)

        println(base64)
    }

    @Test
    fun testPathPattern() {
        val publicPath = listOf("/api/v1/public/**")
        val patters = mutableListOf<PathPattern>()

        publicPath.forEach {
            patters.add(PathPatternParser.defaultInstance.parse(it))
        }

        patters.forEach{
            if(it.matches(PathContainer.parsePath("/api/v1/public/ping")))
                println("Pass through")
        }
    }
}