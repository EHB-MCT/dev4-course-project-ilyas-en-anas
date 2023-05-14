package com.example.medialab.observer

import com.example.medialab.service.LoanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class LoanObserverConfig {

    @Autowired
    fun configureLoanObservers(loanService: LoanService, emailService: EmailService) {
        loanService.addObserver(emailService)
    }
}
