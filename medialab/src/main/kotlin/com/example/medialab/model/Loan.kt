package com.example.medialab.model

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "loans")
data class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    val item: Item,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User,

    @Column(nullable = false)
    val startDate: LocalDate,

    @Column(nullable = false)
    val endDate: LocalDate,

    val notes: String? = null
)
