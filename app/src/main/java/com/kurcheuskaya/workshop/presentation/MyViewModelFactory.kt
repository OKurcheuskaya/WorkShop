package com.kurcheuskaya.workshop.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kurcheuskaya.workshop.data.api.RetrofitService
import com.kurcheuskaya.workshop.data.repository.MainRepositoryImpl
import com.kurcheuskaya.workshop.domain.usecase.GetAllMovieUseCase

class MyViewModelFactory : ViewModelProvider.Factory {

    private val repository by lazy { MainRepositoryImpl(RetrofitService.getApi()) }

    private val allMovieUseCase by lazy { GetAllMovieUseCase(repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(allMovieUseCase) as T
    }
}