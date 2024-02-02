package com.phihai91.bankservice.adapter.`in`.web.configuration

import com.phihai91.bankservice.common.API_KEY
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(info = Info(title = "Bank API", version = "v1"))
@SecurityScheme(name = "apiKey", type = SecuritySchemeType.APIKEY, paramName = API_KEY, `in` = SecuritySchemeIn.HEADER)
class OpenAPIConfiguration {

}