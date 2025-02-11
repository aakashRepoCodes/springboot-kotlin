package com.luna.spring.repositories

import com.luna.spring.domain.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorRepository: JpaRepository<Author, Long>