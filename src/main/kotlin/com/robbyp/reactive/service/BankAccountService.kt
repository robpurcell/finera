package com.robbyp.reactive.service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

import com.robbyp.reactive.domain.BankAccountDetails

interface BankAccountService {
  fun createBankAccount(bankAccountDetails: BankAccountDetails): Mono<String>

  fun saveBankAccount(bankAccountDetails: BankAccountDetails): Mono<BankAccountDetails>

  fun findOne(id: String): Mono<BankAccountDetails>

  fun countByBalance(balance: Int): Mono<Long>

  fun removeByBalance(balance: Int): Flux<BankAccountDetails>

  fun findByBalance(balance: Int): Flux<BankAccountDetails>

  fun findByFixedDepositsTenureLessThan(tenure: Int): Flux<BankAccountDetails>

  fun findByFixedDepositsFdAmountGreaterThan(fdAmount: Int): Flux<BankAccountDetails>

  fun findTop2ByOrderByFixedDepositsFdCreationDateDesc(): Flux<BankAccountDetails>

  fun findTop2ByFixedDepositsTenure(tenure: Int): Flux<BankAccountDetails>

  fun findByFixedDepositsTenureAndFixedDepositsFdAmount(
      tenure: Int, fdAmount: Int): Flux<BankAccountDetails>

  fun findByCustomQuery(balance: Int): Flux<BankAccountDetails>

  fun addFixedDeposit(bankAccountId: String, amount: Int): Mono<Void>
}
