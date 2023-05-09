package com.example.medialab.Dto

data class UserDto(
    val name: String? = null,
    val email: String,
    val password: String,
    val roleId: Long
)
