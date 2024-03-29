package com.example.tmdbclient.data.domain.usecase

import com.example.tmdbclient.data.domain.repository.movie.repository.MovieRepository
import com.example.tmdbclient.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.updateMovies()

}