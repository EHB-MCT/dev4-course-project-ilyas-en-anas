package com.example.medialab.observer

import com.example.medialab.model.Loan

interface LoanObserver {
    fun onLoanEndDateExceeded(loan: Loan)
}