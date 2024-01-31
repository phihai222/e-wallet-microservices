package com.phihai91.bankservice.adapter.out.persistence

import org.apache.ibatis.annotations.Select

interface IntegrationServiceRepository {
    @Select("SELECT * FROM integration_service")
    fun getAllService() : List<IntegrationServiceEntity>
}