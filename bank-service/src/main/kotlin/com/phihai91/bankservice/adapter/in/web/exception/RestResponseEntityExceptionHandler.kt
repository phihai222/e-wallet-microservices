package com.phihai91.bankservice.adapter.`in`.web.exception

import com.phihai91.bankservice.adapter.`in`.web.dto.CommonErrorResponse
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import reactor.core.publisher.Mono

@ControllerAdvice
class RestResponseEntityExceptionHandler {
    @ExceptionHandler
    fun handleNotFound(ex: EntityNotFoundException): Mono<ResponseEntity<CommonErrorResponse>> {
        val res = ex.message?.let { CommonErrorResponse(it) }
        return Mono.just(ResponseEntity<CommonErrorResponse>(res, HttpStatus.NOT_FOUND))
    }

    @ExceptionHandler
    fun handleValidation(ex: ConstraintViolationException): Mono<ResponseEntity<CommonErrorResponse>> {
        val res = ex.message?.let { CommonErrorResponse(it) }
        return Mono.just(ResponseEntity<CommonErrorResponse>(res, HttpStatus.BAD_REQUEST))
    }
}