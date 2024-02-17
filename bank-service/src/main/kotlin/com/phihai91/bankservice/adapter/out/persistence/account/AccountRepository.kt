package com.phihai91.bankservice.adapter.out.persistence.account

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select

@Mapper
interface AccountRepository {

    @Select("SELECT EXISTS(SELECT 1 FROM account WHERE mobile_number=#{mobileNumber})")
    fun existedByMobileNumber(mobileNumber: String): Boolean

    @Insert("INSERT INTO account(account_number, mobile_number,passcode,account_type,balance_baseline,wallet_connected,status,created_at)" +
            "values('#{accountNumber},#{mobileNumber},#{passcode},#{accountType},#{balanceBaseline},#{walletConnected},#{status},#{createdAt}')")
    fun saveAccount(account: AccountEntity)

    @Select("SELECT * FROM account WHERE account_number=#{accountNumber}")
    @Results(
        Result(column = "account_number", property = "accountNumber"),
        Result(column = "mobile_number", property = "mobileNumber"),
        Result(column = "passcode", property = "passcode"),
        Result(column = "account_type", property = "accountType"),
        Result(column = "balance_baseline", property = "balanceBaseline"),
        Result(column = "wallet_connected", property = "walletConnected"),
        Result(column = "status", property = "status"),
        Result(column = "created_at", property = "createdAt"))
    fun findByAccountNumber(accountNumber: String) : AccountEntity?
}