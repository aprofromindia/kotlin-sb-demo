package com.github.apro.kotlinspring.users

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
internal data class User(
  val name: String,
  @JsonProperty("class")
  val clazz: Int,
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: Long = -1
)
