package com.example.tmdbclient.data.domain.repository.tvShow.dataSource

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.data.model.tvshow.TVShowList

interface TvShowsLocalDataSource {
    suspend fun getTvShows() : List<TVShow>
    suspend fun saveTvShowsToDB(tvShowList : List<TVShow>)
    suspend fun clearAll()
}