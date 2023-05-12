package com.example.medialab.Dto

import java.time.LocalDate

data class LoanDto(
    val itemId: Long,
    val userId: Long,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val notes: String? = null
)
