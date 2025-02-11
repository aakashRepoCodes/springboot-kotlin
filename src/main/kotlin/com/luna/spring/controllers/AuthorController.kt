package com.luna.spring.controllers

import com.luna.spring.domain.Author
import com.luna.spring.dto.AuthorDTO
import com.luna.spring.dto.AuthorResponseDTO
import com.luna.spring.repositories.AuthorRepository
import com.luna.spring.service.AuthorService
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/author")
class AuthorController {

    @Autowired
    private lateinit var authorService: AuthorService

    @PostMapping
    fun createAuthor(@RequestBody @Validated authorDto: AuthorDTO): ResponseEntity<AuthorResponseDTO> {
        val response = authorService.saveAuthor(authorDto)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping
    fun getAuthors(): ResponseEntity<List<AuthorResponseDTO>> {
        return ResponseEntity(authorService.getAuthors(), HttpStatus.OK)
    }

}