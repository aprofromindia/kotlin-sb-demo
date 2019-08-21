package com.github.apro.kotlinspring.users

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class UserConfig {

  @Bean
  fun populateUsers(repository: UserRepository) = CommandLineRunner {
    repository.apply {
      save(User("tom", 1))
      save(User("tomat", 2))
      save(User("tomato", 3))
      save(User("tom1", 5))
      save(User("tom2", 9))
    }
  }
}
