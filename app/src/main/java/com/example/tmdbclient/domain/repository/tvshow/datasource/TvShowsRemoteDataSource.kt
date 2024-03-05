package com.example.tmdbclient.data.domain.repository.tvShow.dataSource

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows() : Response<TVShowList>
}