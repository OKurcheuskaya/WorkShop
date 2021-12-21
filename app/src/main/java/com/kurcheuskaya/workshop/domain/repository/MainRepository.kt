package com.kurcheuskaya.workshop.domain.repository

import com.kurcheuskaya.workshop.domain.model.Movie

interface MainRepository {
    suspend fun getAllMovies(): List<Movie>?
}