package com.phihai91.bankservice.adapter.out.persistence

import org.apache.ibatis.annotations.*

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
    fun getIntegratorById(id: String): IntegratorEntity?

    @Insert("INSERT INTO integrator(id,api_key,service_name,status,created_at,expired_at) " +
            "values(#{id},#{apiKey},#{serviceName},#{status},#{createdAt},#{expiredAt})")
    fun save(integrator: IntegratorEntity)
}