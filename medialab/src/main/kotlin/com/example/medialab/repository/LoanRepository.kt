package com.example.medialab.repository

import com.example.medialab.model.Loan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LoanRepository : JpaRepository<Loan, Long> {
    fun findAllByUserId(userId: Long): List<Loan>
}