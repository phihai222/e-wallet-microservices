package com.phihai91.bankservice.adapter.out.persistence.integrator

import com.phihai91.bankservice.application.domain.model.Integrator
import com.phihai91.bankservice.application.domain.model.IntegratorType
import com.phihai91.bankservice.application.domain.model.Status

fun mapDomainToEntity(input: Integrator): IntegratorEntity {
    return input.let {
        IntegratorEntity(
                id = it.id,
                serviceName = it.name,
                apiKey = it.apiKey,
                createdAt = it.createAt,
                expiredAt = it.expireTime,
                status = it.status.toString(),
                type = it.type.toString()
        )
    }
}

fun mapEntityToDomain(input: IntegratorEntity): Integrator {
    return input.let {
        Integrator(
                id = it.id,
                createAt = it.createdAt,
                apiKey = it.apiKey,
                status = Status.valueOf(it.status),
                name = it.serviceName,
                expireTime = it.expiredAt,
                type = IntegratorType.valueOf(it.type)
        )
    }
}