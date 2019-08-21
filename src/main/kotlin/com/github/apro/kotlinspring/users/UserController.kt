package com.github.apro.kotlinspring.users

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("/users")
internal class UserController(val service: UserService) {

  @GetMapping
  fun getUsers() = service.getUsers().also {
    logger.info("get users called")
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun createUser(@RequestBody user: User) = service.save(user).also {
    logger.info("$it is created.")
  }

  @PatchMapping("{id}")
  @ResponseStatus(HttpStatus.CREATED)
  fun updateUser(@PathVariable id: Long,
                 @RequestBody userMap: Map<String, Any>) = service.updateUser(id, userMap).also {
    logger.info("user $id updated.")
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun delUser(@PathVariable id: Long) = service.delUser(id).also {
    logger.info("user $id deleted.")
  }
}
