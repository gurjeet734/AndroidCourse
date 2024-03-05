package com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl

import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesLocalDataSource
import com.example.tmdbclient.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesLocalDataSourceImpl(private val movieDao: MovieDao) : MoviesLocalDataSource {
    override suspend fun getMovies(): List<Movie> = movieDao.getAllMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}