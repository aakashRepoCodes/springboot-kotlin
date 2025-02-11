package com.luna.spring.service

import com.luna.spring.domain.Author
import com.luna.spring.dto.AuthorDTO
import com.luna.spring.dto.AuthorResponseDTO
import com.luna.spring.dto.toEntity
import com.luna.spring.repositories.AuthorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthorService {

    @Autowired
    private lateinit var authorRepository: AuthorRepository

    fun saveAuthor(authorDTO: AuthorDTO): AuthorResponseDTO {
        val savedAuthor =  authorRepository.save(authorDTO.toEntity())
        return AuthorResponseDTO(
            savedAuthor.name,
            savedAuthor.imageUrl
        )
    }

    fun getAuthors(): List<AuthorResponseDTO> {
        val authors = mutableListOf<AuthorResponseDTO>()
        for (author in authorRepository.findAll()) {
            authors.add(AuthorResponseDTO(
                author.name,
                author.imageUrl
            ))
        }
        return authors
    }
}