package com.luna.spring.domain

import jakarta.persistence.*
import java.util.*

@Entity
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val isbn: String,

    val title: String,
    val description: String,
    val image: String,
    val publishedDate: Date,

    @ManyToOne(cascade = [CascadeType.DETACH])
    @JoinColumn(name = "author_id")
    val author: Author
)