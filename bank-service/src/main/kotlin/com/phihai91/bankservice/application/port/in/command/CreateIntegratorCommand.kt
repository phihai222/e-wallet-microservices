package com.phihai91.bankservice.application.port.`in`.command

import jakarta.validation.constraints.NotEmpty

data class CreateIntegratorCommand(
    @NotEmpty val name: String,
) {
    // TODO add validation here
}
