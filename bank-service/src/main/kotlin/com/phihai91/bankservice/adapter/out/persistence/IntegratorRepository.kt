package com.phihai91.bankservice.adapter.out.persistence

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

@Mapper
interface IntegratorRepository {
    @Select("SELECT * FROM integrator WHERE id = #{id}")
    @Results(
            Result(column = "id", property = "id"),
            Result(column = "api_key", property = "apiKey"),
            Result(column = "service_name", property = "serviceName"),
            Result(column = "status", property = "status"),
            Result(column = "created_at", property = "createdAt"),
            Result(column = "expired_at", property = "expiredAt"),
    )
    fun getIntegratorById(id: String): IntegratorEntity
}