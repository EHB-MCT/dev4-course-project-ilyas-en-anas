package com.example.medialab.controller

import com.example.medialab.service.LoanService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/loans")
class LoanController(private val loanService: LoanService) {
}