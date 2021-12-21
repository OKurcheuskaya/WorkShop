package com.kurcheuskaya.workshop.domain.usecase

import com.kurcheuskaya.workshop.domain.model.Movie
import com.kurcheuskaya.workshop.domain.repository.MainRepository

class GetAllMovieUseCase(private val repository: MainRepository) {
    suspend fun execute(): List<Movie>? {
        return repository.getAllMovies()
    }
}