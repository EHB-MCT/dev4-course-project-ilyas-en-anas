package com.example.medialab.controller

import com.example.medialab.Dto.UserDto
import com.example.medialab.model.User
import com.example.medialab.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*


@CrossOrigin
@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping("/allusers")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDto: UserDto): User =
        userService.updateUser(id, userDto)

    @PostMapping("/add")
    fun createUser(@RequestBody userDto: UserDto?): ResponseEntity<User?>? {
        val newUser = userService.createUser(userDto!!)
        return ResponseEntity(newUser, HttpStatus.CREATED)
    }


    @PostMapping("/register")
    fun registerUser(@RequestBody userDto: UserDto): User {
        return userService.createUser(userDto)
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody userDto: UserDto): ResponseEntity<Map<String, Any>> {
        val user = userService.findByEmail(userDto.email)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(mapOf("message" to "User not found"))

        if (!BCryptPasswordEncoder().matches(userDto.password, user.password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(mapOf("message" to "Incorrect password"))
        }

        val loggedInUserDto = UserDto(
            name = user.name,
            email = user.email,
            password = "",
            roleId = user.role.id,
            userId = user.id
        )

        return ResponseEntity.status(HttpStatus.OK).body(
            mapOf(
                "message" to "Login successful",
                "user" to loggedInUserDto
            )
        )
    }

}