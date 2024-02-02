package com.phihai91.bankservice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.crypto.keygen.KeyGenerators
import java.util.Base64

@ExtendWith(MockitoExtension::class)
class MyTest {
    @Test
    fun generateKey() {
        val generator = KeyGenerators.secureRandom(32)
        val key = generator.generateKey()
        val base64 = Base64.getEncoder().encodeToString(key)

        println(base64)
    }
}