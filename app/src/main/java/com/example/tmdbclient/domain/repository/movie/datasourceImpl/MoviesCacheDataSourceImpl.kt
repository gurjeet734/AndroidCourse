package com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl

import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesCacheDataSource
import com.example.tmdbclient.data.model.movie.Movie

class MoviesCacheDataSourceImpl : MoviesCacheDataSource {
    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}