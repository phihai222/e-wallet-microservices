package com.phihai91.bankservice.common.anotations

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class PersistenceAdapter(
        @get: AliasFor(annotation = Component::class)
        val value: String = ""
)
