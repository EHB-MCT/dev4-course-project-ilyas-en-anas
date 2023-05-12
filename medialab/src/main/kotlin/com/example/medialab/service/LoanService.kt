package com.example.medialab.service

import com.example.medialab.Dto.LoanDto
import com.example.medialab.model.Item
import com.example.medialab.model.Loan
import com.example.medialab.model.User
import com.example.medialab.repository.ItemRepository
import com.example.medialab.repository.LoanRepository
import com.example.medialab.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LoanService(private val loanRepository: LoanRepository, private val itemRepository: ItemRepository, private val userRepository: UserRepository) {
    fun getAllLoans(): List<Loan> = loanRepository.findAll()

    fun getLoanById(id: Long): Loan = loanRepository.findById(id).orElseThrow { Exception("Loan not found") }

    fun createLoan(loanDto: LoanDto): Loan {
        val item = itemRepository.findById(loanDto.itemId).orElseThrow { Exception("Item not found") }
        val user = userRepository.findById(loanDto.userId).orElseThrow { Exception("User not found") }

        val loan = Loan(
            item = item,
            user = user,
            startDate = loanDto.startDate,
            endDate = loanDto.endDate,
            notes = loanDto.notes
        )

        return loanRepository.save(loan)
    }

    fun updateLoan(id: Long, loanDto: LoanDto): Loan {
        val existingLoan = getLoanById(id)
        val item = itemRepository.findById(loanDto.itemId).orElseThrow { Exception("Item not found") }
        val user = userRepository.findById(loanDto.userId).orElseThrow { Exception("User not found") }
        val updatedLoan = existingLoan.copy(
            item = item,
            user = user,
            startDate = loanDto.startDate,
            endDate = loanDto.endDate,
            notes = loanDto.notes
        )
        return loanRepository.save(updatedLoan)
    }


    fun deleteLoan(id: Long) = loanRepository.deleteById(id)
}