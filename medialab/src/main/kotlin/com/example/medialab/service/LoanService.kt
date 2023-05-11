package com.example.medialab.service

import com.example.medialab.model.Item
import com.example.medialab.model.Loan
import com.example.medialab.model.User
import com.example.medialab.repository.LoanRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LoanService(private val loanRepository: LoanRepository) {
    fun getAllLoans(): List<Loan> = loanRepository.findAll()

    fun getLoanById(id: Long): Loan = loanRepository.findById(id).orElseThrow { Exception("Loan not found") }

    fun createLoan(loan: Loan): Loan = loanRepository.save(loan)

    fun updateLoan(id: Long, item: Item, user: User, startDate: LocalDate, endDate: LocalDate, notes: String?): Loan {
        val existingLoan = getLoanById(id)
        val updatedLoan = existingLoan.copy(
            item = item,
            user = user,
            startDate = startDate,
            endDate = endDate,
            notes = notes
        )
        return loanRepository.save(updatedLoan)
    }


    fun deleteLoan(id: Long) = loanRepository.deleteById(id)
}