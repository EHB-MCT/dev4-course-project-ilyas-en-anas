package com.example.medialab.service

import com.example.medialab.model.Role
import com.example.medialab.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(private val roleRepository: RoleRepository) {
    fun createRole(roleName: String): Role {
        val role = Role(name = roleName)
        return roleRepository.save(role)
    }
}