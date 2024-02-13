package com.phihai91.bankservice.adapter.out.persistence.account

import org.apache.ibatis.annotations.Mapper

@Mapper
interface AccountRepository {
    // TODO("Query")
    fun existedByMobileNumber(mobileNumber: String) : Boolean
}