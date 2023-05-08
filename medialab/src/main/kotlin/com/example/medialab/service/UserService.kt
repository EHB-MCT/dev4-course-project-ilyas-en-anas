package com.example.medialab.service

import com.example.medialab.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

}