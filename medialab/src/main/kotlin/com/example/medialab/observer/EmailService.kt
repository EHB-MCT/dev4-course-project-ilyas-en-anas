package com.example.medialab.observer

import com.example.medialab.model.Loan
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(private val emailSender: JavaMailSender) : LoanObserver {
    override fun onLoanEndDateExceeded(loan: Loan) {
        sendSimpleMessage(
            loan.user.email,
            "Date exceeded EHB medialab",
            "You have exceeded the date(${loan.endDate}) for the following loaned item: ${loan.item.name} .Bring it back to the EHB medialab or we'll call the cops!"
        )
    }
    fun sendSimpleMessage(to: String, subject: String, text: String) {
        val message = SimpleMailMessage()
        message.setFrom("ehbmedialab0@gmail.com")
        message.setTo(to)
        message.setSubject(subject)
        message.setText(text)
        emailSender.send(message)
    }
}