package com.phihai91.bankservice.application.port.`in`.account.command

import com.phihai91.bankservice.common.anotations.validator.DigitsNumber
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NumberValidator : ConstraintValidator<DigitsNumber, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val regex = "[0-9]+".toRegex()
        return value?.matches(regex) ?: false
    }
}