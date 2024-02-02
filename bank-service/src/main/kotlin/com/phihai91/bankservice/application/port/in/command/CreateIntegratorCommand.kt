package com.phihai91.bankservice.application.port.`in`.command

import org.jetbrains.annotations.NotNull

data class CreateIntegratorCommand(
    @NotNull val name: String,
) {
    // TODO add validation here
}
