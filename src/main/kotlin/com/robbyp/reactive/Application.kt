package com.robbyp.reactive

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


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class Application {

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(Application::class.java, *args)
    }
  }

//  @Bean
//  fun routes(): RouterFunction<ServerResponse> {
//    return resources("/**", ClassPathResource("static/"))
//  }

  //  @Bean
//  fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
//    return { args ->
//
//      println("Let's inspect the beans provided by Spring Boot:")
//
//      val beanNames = ctx.beanDefinitionNames
//      Arrays.sort(beanNames)
//      for (beanName in beanNames) {
//        println(beanName)
//      }
//
//    }
//  }

}
