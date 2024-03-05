package com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesRemoteDataSource
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,
    private val apiKey : String) : MoviesRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList>  = tmdbService.getPopularMovies(apiKey)
}