package com.kurcheuskaya.workshop.presentation

import androidx.lifecycle.*
import com.kurcheuskaya.workshop.domain.model.Movie
import com.kurcheuskaya.workshop.domain.usecase.GetAllMovieUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getAllMovieUseCase: GetAllMovieUseCase) : ViewModel() {

    private val listMovie = MutableLiveData<List<Movie>>()
    val listMovieList: LiveData<List<Movie>> = listMovie
    private val error = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = error

    fun getMovies() {
        viewModelScope.launch {
            val result = getAllMovieUseCase.execute()
            listMovie.postValue(result)
        }
    }
}