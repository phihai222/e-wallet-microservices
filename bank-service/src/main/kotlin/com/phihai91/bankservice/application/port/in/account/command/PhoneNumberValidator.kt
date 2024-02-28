package com.phihai91.bankservice.application.port.`in`.account.command

import com.phihai91.bankservice.common.anotations.validator.PhoneNumber
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class PhoneNumberValidator : ConstraintValidator<PhoneNumber, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        // TODO add validate logic
        return true
    }
}