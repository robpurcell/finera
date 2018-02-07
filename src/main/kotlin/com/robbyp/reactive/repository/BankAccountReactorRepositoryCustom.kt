package com.robbyp.reactive.repository

import reactor.core.publisher.Mono

interface BankAccountReactorRepositoryCustom {
  fun addFixedDeposit(bankAccountId: String, amount: Int): Mono<Void>
}
