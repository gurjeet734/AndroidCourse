package com.example.tmdbclient.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.data.model.movie.Movie

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() : LiveData<List<Movie>?> = liveData {
        var listMovie : List<Movie>? = getMoviesUseCase.execute()
        emit(listMovie)
    }

    fun updateMovies() : LiveData<List<Movie>?> = liveData {
        var listMovie : List<Movie>? = updateMoviesUseCase.execute()
        emit(listMovie)
    }


}