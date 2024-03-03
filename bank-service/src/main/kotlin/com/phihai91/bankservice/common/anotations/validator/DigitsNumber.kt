package com.phihai91.bankservice.common.anotations.validator

import com.phihai91.bankservice.application.port.`in`.account.command.NumberValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [NumberValidator::class])
@MustBeDocumented
annotation class DigitsNumber(
    val message: String = "Must be number format",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)