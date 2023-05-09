package com.example.medialab.controller

import com.example.medialab.Dto.UserDto
import com.example.medialab.model.User
import com.example.medialab.service.UserService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @PostMapping("/register")
    fun registerUser(@RequestBody userDto: UserDto): User {
        return userService.createUser(userDto)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody userDto: UserDto): String {
        val user = userService.findByEmail(userDto.email)
            ?: return "User not found"

        if (!BCryptPasswordEncoder().matches(userDto.password, user.password)) {
            return "Incorrect password"
        }

        return "Login successful"
    }
}