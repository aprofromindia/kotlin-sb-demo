package com.github.apro.kotlinspring.users

import org.springframework.data.repository.CrudRepository

internal interface UserRepository : CrudRepository<User, Long>
