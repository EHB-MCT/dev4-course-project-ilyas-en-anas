package com.example.medialab.controller

import com.example.medialab.model.Role
import com.example.medialab.service.RoleService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/roles")
class RoleController(private val roleService: RoleService) {
    @PostMapping
    fun createRole(@RequestBody roleName: String): Role {
        return roleService.createRole(roleName)
    }
}