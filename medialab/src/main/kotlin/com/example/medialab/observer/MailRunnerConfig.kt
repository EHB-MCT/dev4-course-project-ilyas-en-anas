package com.example.medialab.observer

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MailRunnerConfig {
    @Bean
    fun runner(emailService: EmailService): ApplicationRunner {
        return ApplicationRunner {
            emailService.sendSimpleMessage(
                "assakaliilyas@gmail.com",
                "Test Subject",
                "Dit is een testbericht"
            )
        }
    }
}