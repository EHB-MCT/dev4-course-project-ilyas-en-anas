package com.example.medialab.service

import com.example.medialab.Dto.UserDto
import com.example.medialab.model.User
import com.example.medialab.repository.RoleRepository
import com.example.medialab.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val roleRepository: RoleRepository) {

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    private val passwordEncoder = BCryptPasswordEncoder()

    fun login(email: String, password: String): User? {
        val user = userRepository.findByEmail(email) ?: return null

        return if (passwordEncoder.matches(password, user.password)) user else null
    }

    fun createUser(userDto: UserDto): User {
        val role = roleRepository.findById(userDto.roleId).orElseThrow { NoSuchElementException("Role not found") }
        val user = User(
            name = userDto.name ?: "Anonymous",
            email = userDto.email,
            password = passwordEncoder.encode(userDto.password),
            role = role
        )
        return userRepository.save(user)
    }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }
}