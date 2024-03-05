package com.example.tmdbclient.data.domain.repository.movie.dataSource

import com.example.tmdbclient.data.model.movie.Movie

interface MoviesLocalDataSource {
    suspend fun getMovies() : List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}