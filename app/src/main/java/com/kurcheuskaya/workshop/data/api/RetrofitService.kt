package com.kurcheuskaya.workshop.data.api

import com.kurcheuskaya.workshop.domain.model.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("movielist.json")
    suspend fun getMovie(): Response<List<Movie>>

    companion object {
        private const val BASE_URL = "https://howtodoandroid.com/"

        private val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        fun getApi(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}