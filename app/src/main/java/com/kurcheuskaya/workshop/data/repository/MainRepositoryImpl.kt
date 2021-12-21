package com.kurcheuskaya.workshop.data.repository

import com.kurcheuskaya.workshop.data.api.RetrofitService
import com.kurcheuskaya.workshop.domain.model.Movie
import com.kurcheuskaya.workshop.domain.repository.MainRepository

class MainRepositoryImpl(private val retrofitService: RetrofitService) : MainRepository {

    override suspend fun getAllMovies(): List<Movie>? {
        return retrofitService.getMovie().body()
    }
}