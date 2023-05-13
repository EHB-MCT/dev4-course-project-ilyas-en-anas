package com.example.medialab.controller

import com.example.medialab.model.Role
import com.example.medialab.service.RoleService
import org.springframework.web.bind.annotation.*


@CrossOrigin
@RestController
@RequestMapping("/api/roles")
class RoleController(private val roleService: RoleService) {
    @PostMapping
    fun createRoles(@RequestBody roleNames: List<String>): List<Role> {
        return roleService.createRoles(roleNames)
    }
}