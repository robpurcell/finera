package com.robbyp.reactive.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "bankaccounts")
data class BankAccountDetails(@Id val accountId: String,
                              var balance: Int,
                              val lastTransactionTimestamp: Date,
                              val fixedDeposits: MutableList<FixedDepositDetails> = mutableListOf(),
                              val count: Long,
                              val findOne: Long) {

  fun addFixedDeposit(fixedDeposit: FixedDepositDetails) {
    fixedDeposits.add(fixedDeposit)
  }

}
