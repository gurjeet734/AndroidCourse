package com.example.tmdbclient.data.domain.repository.movie.dataSource

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MoviesRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}