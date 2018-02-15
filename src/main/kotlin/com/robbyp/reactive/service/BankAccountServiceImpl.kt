package com.robbyp.reactive.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

import com.robbyp.reactive.domain.BankAccountDetails
import com.robbyp.reactive.repository.BankAccountReactorRepository

@Service
class BankAccountServiceImpl : BankAccountService {
  @Autowired
  private val bankAccountRepository: BankAccountReactorRepository? = null

  override fun createBankAccount(bankAccountDetails: BankAccountDetails): Mono<String> {
    return bankAccountRepository!!.save(bankAccountDetails).map { (accountId) -> accountId }
  }

  override fun saveBankAccount(bankAccountDetails: BankAccountDetails): Mono<BankAccountDetails> {
    return bankAccountRepository!!.save(bankAccountDetails)
  }

  override fun findOne(id: String): Mono<BankAccountDetails> {
    return bankAccountRepository!!.findById(id)
  }

  override fun countByBalance(balance: Int): Mono<Long> {
    return bankAccountRepository!!.countByBalance(balance)
  }

  override fun removeByBalance(balance: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.removeByBalance(balance)
  }

  override fun findByBalance(balance: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findByBalance(balance)
  }

  override fun findByFixedDepositsTenureLessThan(tenure: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findByFixedDepositsTenureLessThan(tenure)
  }

  override fun findByFixedDepositsFdAmountGreaterThan(fdAmount: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findByFixedDepositsFdAmountGreaterThan(fdAmount)
  }

  override fun findTop2ByOrderByFixedDepositsFdCreationDateDesc(): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findTop2ByOrderByFixedDepositsFdCreationDateDesc()
  }

  override fun findTop2ByFixedDepositsTenure(tenure: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findTop2ByFixedDepositsTenure(tenure)
  }

  override fun findByFixedDepositsTenureAndFixedDepositsFdAmount(
      tenure: Int, fdAmount: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findByFixedDepositsTenureAndFixedDepositsFdAmount(tenure, fdAmount)
  }

  override fun findByCustomQuery(balance: Int): Flux<BankAccountDetails> {
    return bankAccountRepository!!.findByCustomQuery(balance)
  }

  override fun addFixedDeposit(bankAccountId: String, amount: Int): Mono<Void> {
    return bankAccountRepository!!.addFixedDeposit(bankAccountId, amount)
  }
}
