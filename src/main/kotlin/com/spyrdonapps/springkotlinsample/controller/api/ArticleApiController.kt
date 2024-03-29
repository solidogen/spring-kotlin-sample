package com.spyrdonapps.springkotlinsample.controller.api

import com.spyrdonapps.springkotlinsample.repository.ArticleRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/article")
class ArticleApiController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByAddedAtDesc()

    @GetMapping("/{slug}")
    fun findBySlug(@PathVariable slug: String) =
        repository.findBySlug(slug) ?: ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
}