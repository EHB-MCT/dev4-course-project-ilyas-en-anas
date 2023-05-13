package com.example.medialab.service

import com.example.medialab.model.Role
import com.example.medialab.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(private val roleRepository: RoleRepository) {
    fun createRoles(roleNames: List<String>): List<Role> {
        return roleNames.map { roleName ->
            val role = Role(name = roleName)
            roleRepository.save(role)
        }
    }
}