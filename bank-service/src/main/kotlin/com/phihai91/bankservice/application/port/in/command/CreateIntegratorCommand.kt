package com.phihai91.bankservice.application.port.`in`.command

import com.phihai91.bankservice.common.validate
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class CreateIntegratorCommand(
       @field:NotEmpty @field:Size(min=10) val name: String,
) {
    init {
        validate(this)
    }
}
