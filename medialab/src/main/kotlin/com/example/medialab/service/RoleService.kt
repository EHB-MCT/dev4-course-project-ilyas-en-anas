package com.example.medialab.service

import com.example.medialab.model.Role
import com.example.medialab.repository.RoleRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class RoleService(private val roleRepository: RoleRepository) {

    @PostConstruct
    fun init() {
        if (roleRepository.findAll().isEmpty()) {
            val roles = listOf("admin", "user")
            createRoles(roles)
        }
    }

    fun createRoles(roleNames: List<String>): List<Role> {
        return roleNames.map { roleName ->
            val role = Role(name = roleName)
            roleRepository.save(role)
        }
    }
}