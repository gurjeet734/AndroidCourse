package com.example.tmdbclient.data.domain.repository.movie.dataSource

import com.example.tmdbclient.data.model.movie.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}