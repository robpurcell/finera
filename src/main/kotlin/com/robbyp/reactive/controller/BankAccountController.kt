package com.robbyp.reactive.controller

import com.robbyp.reactive.domain.BankAccountDetails
import com.robbyp.reactive.service.BankAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/bankaccount")
class BankAccountController {
  @Autowired
  private val bankAccountService: BankAccountService? = null

  @PostMapping("/createBankAccount")
  fun createBankAccount(@RequestBody bankAccountDetails: BankAccountDetails): Mono<String> {
    return bankAccountService!!.createBankAccount(bankAccountDetails)
  }

  @PostMapping("/saveBankAccount")
  fun saveBankAccount(@RequestBody bankAccountDetails: BankAccountDetails): Mono<BankAccountDetails> {
    return bankAccountService!!.saveBankAccount(bankAccountDetails)
  }

  @GetMapping("/findOne/{id}")
  fun findOne(@PathVariable("id") bankAccountId: String): Mono<BankAccountDetails> {
    return bankAccountService!!.findOne(bankAccountId)
  }

  @GetMapping("/countByBalance/{balance}")
  fun countByBalance(@PathVariable("balance") balance: Int): Mono<Long> {
    return bankAccountService!!.countByBalance(balance)
  }

  @PutMapping("/removeByBalance/{balance}")
  fun removeByBalance(@PathVariable("balance") balance: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.removeByBalance(balance)
  }

  @GetMapping("/findByBalance/{balance}")
  fun findByBalance(@PathVariable("balance") balance: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findByBalance(balance)
  }

  @GetMapping("/findByFixedDepositsTenureLessThan/{tenure}")
  fun findByFixedDepositsTenureLessThan(@PathVariable("tenure") tenure: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findByFixedDepositsTenureLessThan(tenure)
  }

  @GetMapping("/findByFixedDepositsFdAmountGreaterThan/{fdAmount}")
  fun findByFixedDepositsFdAmountGreaterThan(@PathVariable("fdAmount") fdAmount: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findByFixedDepositsFdAmountGreaterThan(fdAmount)
  }

  @GetMapping("/findTop2ByOrderByFixedDepositsFdCreationDateDesc")
  fun findTop2ByOrderByFixedDepositsFdCreationDateDesc(): Flux<BankAccountDetails> {
    return bankAccountService!!.findTop2ByOrderByFixedDepositsFdCreationDateDesc()
  }

  @GetMapping("/findTop2ByFixedDepositsTenure/{tenure}")
  fun findTop2ByFixedDepositsTenure(@PathVariable("tenure") tenure: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findTop2ByFixedDepositsTenure(tenure)
  }

  @GetMapping("/findByFixedDepositsTenureAndFixedDepositsFdAmount/{tenure}/{fdAmount}")
  fun findByFixedDepositsTenureAndFixedDepositsFdAmount(
      @PathVariable("tenure") tenure: Int, @PathVariable("fdAmount") fdAmount: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findByFixedDepositsTenureAndFixedDepositsFdAmount(tenure, fdAmount)
  }

  @GetMapping("/findByCustomQuery/{balance}")
  fun findByCustomQuery(@PathVariable("balance") balance: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findByCustomQuery(balance)
  }

  @GetMapping(path = arrayOf("/findByCustomQuerySse/{balance}"), produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
  fun findByCustomQuerySse(@PathVariable("balance") balance: Int): Flux<BankAccountDetails> {
    return bankAccountService!!.findByCustomQuery(balance).doOnNext({ _ ->
                                                                      try {
                                                                        Thread.sleep(1000)
                                                                      }
                                                                      catch (e: InterruptedException) {
                                                                        e.printStackTrace()
                                                                      }
                                                                    })
  }

  @PutMapping("/addFixedDeposit/{bankAccountId}/{amount}")
  fun addFixedDeposit(@PathVariable("bankAccountId") bankAccountId: String,
                      @PathVariable("amount") amount: Int): Mono<Void> {
    return bankAccountService!!.addFixedDeposit(bankAccountId, amount)
  }

}
