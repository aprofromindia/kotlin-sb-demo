package com.github.apro.kotlinspring.users

import org.springframework.stereotype.Service

@Service
internal class UserService(val repository: UserRepository) {

  fun getUsers() = repository.findAll().toList()

  fun save(user: User) = repository.save(user)

  fun updateUser(id: Long, map: Map<String, Any>) {
    repository.findById(id).ifPresent {
      var user = it
      for ((k, v) in map) {
        when (k) {
          "name" -> user = it.copy(name = v as String)
          "class" -> user = it.copy(clazz = v as Int)
        }
      }
      repository.save(user)
    }
  }

  fun delUser(id: Long) = repository.deleteById(id)
}
