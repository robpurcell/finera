package com.robbyp.reactive.repository

import com.robbyp.reactive.domain.BankAccountDetails
import com.robbyp.reactive.domain.FixedDepositDetails
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import reactor.core.Disposable
import reactor.core.publisher.Mono
import java.util.*

class BankAccountReactorRepositoryCustomImpl : BankAccountReactorRepositoryCustom {
  @Autowired
  private val mongoTemplate: ReactiveMongoTemplate? = null

  override fun addFixedDeposit(bankAccountId: String, amount: Int): Mono<Void> {
    return mongoTemplate!!.findById(bankAccountId, BankAccountDetails::class.java)
        .map<Disposable> { account -> addFD(account, amount).subscribe() }
        .then()
  }

  private fun addFD(bankAccountDetails: BankAccountDetails, amount: Int): Mono<BankAccountDetails> {
    if (bankAccountDetails.balance < amount) {
      throw RuntimeException("Insufficient balance amount in bank account")
    }

    val fd2 = FixedDepositDetails(fdCreationDate = Date(), fdAmount = amount, tenure = 7, active = "Y")

    bankAccountDetails.addFixedDeposit(fd2)
    bankAccountDetails.balance = bankAccountDetails.balance - amount

    return mongoTemplate!!.save(bankAccountDetails)
  }
}
