package com.phihai91.bankservice.common.anotations.validator

import com.phihai91.bankservice.application.port.`in`.account.command.PhoneNumberValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PhoneNumberValidator::class])
@MustBeDocumented
annotation class PhoneNumber(
    val message: String = "Must be phone number format",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)