package com.example.medialab.controller

import com.example.medialab.Dto.LoanDto
import com.example.medialab.model.Loan
import com.example.medialab.service.LoanService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/loans")
class LoanController(private val loanService: LoanService) {
    @GetMapping("")
    fun getAllLoans(): List<Loan> = loanService.getAllLoans()

    @GetMapping("/{id}")
    fun getLoanById(@PathVariable id: Long): Loan = loanService.getLoanById(id)

    @PostMapping("")
    fun createLoan(@RequestBody loanDto: LoanDto): Loan = loanService.createLoan(loanDto)

    @PutMapping("/{id}")
    fun updateLoan(@PathVariable id: Long, @RequestBody loanDto: LoanDto): Loan =
        loanService.updateLoan(id, loanDto)

    @DeleteMapping("/{id}")
    fun deleteLoan(@PathVariable id: Long) = loanService.deleteLoan(id)

    @GetMapping("/user/{userId}")
    fun getLoansByUserId(@PathVariable userId: Long): List<Loan> = loanService.getLoansByUserId(userId)

    @PatchMapping("/{id}/notes")
    fun addNoteToLoan(@PathVariable id: Long, @RequestBody note: String): Loan {
        return loanService.addNoteToLoan(id, note)
    }


}