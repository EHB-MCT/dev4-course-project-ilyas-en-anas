package com.example.medialab.model

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "loans")
data class Loan(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    var item: Item,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User,

    @Column(nullable = false)
    var startDate: LocalDate,

    @Column(nullable = false)
    var endDate: LocalDate,

    var notes: String? = null
)
