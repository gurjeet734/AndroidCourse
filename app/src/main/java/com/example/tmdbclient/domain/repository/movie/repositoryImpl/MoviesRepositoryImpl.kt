package com.example.tmdbclient.data.domain.repository.movie.repositoryImpl

import android.util.Log
import com.example.tmdbclient.data.domain.repository.movie.repository.MovieRepository
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesCacheDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesLocalDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesRemoteDataSource
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

import java.lang.Exception

class MoviesRepositoryImpl(
    private val moviesRemoteDataSource: MoviesRemoteDataSource,
    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val moviesCacheDataSource: MoviesCacheDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }


    override suspend fun updateMovies(): List<Movie> {
        var newListOfMovies : List<Movie> = getMoviesFromAPI()
        moviesLocalDataSource.clearAll()
        moviesLocalDataSource.saveMoviesToDB(newListOfMovies)
        moviesCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI() : List<Movie>{
        lateinit var moviesList: List<Movie>

        try {
            var response : Response<MovieList> = moviesRemoteDataSource.getMovies()
            var body : MovieList? = response!!.body()
            if(body != null)
            {
                moviesList = body.movie
            }
        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }
        return moviesList
    }

    private suspend fun getMoviesFromDB() : List<Movie>{
        lateinit var moviesList: List<Movie>

        try {
                moviesList = moviesLocalDataSource.getMovies()
        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }

        if(moviesList.size > 0) {
            return moviesList
        }
        else{
            moviesList = getMoviesFromAPI()
            moviesLocalDataSource.saveMoviesToDB(moviesList)
        }

        return moviesList
    }


    private suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var moviesList: List<Movie>

        try {

            moviesList = moviesCacheDataSource.getMoviesFromCache()

        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }

        if(moviesList.size > 0) {
            return moviesList
        }
        else{
            moviesList = getMoviesFromDB()
            moviesCacheDataSource.saveMoviesToCache(moviesList)
        }

        return moviesList
    }

}