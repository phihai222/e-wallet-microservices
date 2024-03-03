package com.phihai91.bankservice.application.port.`in`.account.command

import com.phihai91.bankservice.common.anotations.validator.DigitsNumber
import com.phihai91.bankservice.common.validate
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CreateAccountCommand(
    @field:NotEmpty @field:DigitsNumber val mobileNumber: String,
    @field:NotEmpty @field:Size(min = 6, max = 6) @field:DigitsNumber val passcode: String
) {
    init {
        validate(this)
    }
}
