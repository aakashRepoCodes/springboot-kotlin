package com.luna.spring.dto

import com.luna.spring.domain.Author

class AuthorDTO (
    val name: String,
    val age: Int,
    val description: String,
    val imageUrl: String
)
fun AuthorDTO.toEntity(): Author {
    return Author(
        id = 0,   // will be ignored at DB operations
        name = name,
        age = age,
        description = description,
        imageUrl = imageUrl
    )
}

