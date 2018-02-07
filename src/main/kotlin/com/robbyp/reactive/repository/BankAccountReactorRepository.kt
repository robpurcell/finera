// Copyright 2018 Purcell Informatics Limited
//
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.robbyp.reactive.repository

import com.robbyp.reactive.domain.BankAccountDetails
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BankAccountReactorRepository : ReactiveMongoRepository<BankAccountDetails, String>, BankAccountReactorRepositoryCustom {

  fun countByBalance(balance: Int): Mono<Long>

  fun removeByBalance(balance: Int): Flux<BankAccountDetails>

  fun findByBalance(balance: Int): Flux<BankAccountDetails>

  fun findByFixedDepositsTenureLessThan(tenure: Int): Flux<BankAccountDetails>

  fun findByFixedDepositsFdAmountGreaterThan(fdAmount: Int): Flux<BankAccountDetails>

  fun findTop2ByOrderByFixedDepositsFdCreationDateDesc(): Flux<BankAccountDetails>

  fun findTop2ByFixedDepositsTenure(tenure: Int): Flux<BankAccountDetails>

  fun findByFixedDepositsTenureAndFixedDepositsFdAmount(tenure: Int, fdAmount: Int): Flux<BankAccountDetails>

  @Query("{ 'balance' : {'\$lte' : ?0} }")
  fun findByCustomQuery(balance: Int): Flux<BankAccountDetails>
}
