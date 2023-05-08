package com.example.medialab.service

import com.example.medialab.repository.LoanRepository
import org.springframework.stereotype.Service

@Service
class LoanService(private val loanRepository: LoanRepository) {

}