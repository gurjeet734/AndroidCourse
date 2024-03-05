package com.example.tmdbclient.data.domain.repository.tvShow.repository

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow

interface TvShowsRepository {

    suspend fun getTvShows() : List<TVShow>

    suspend fun updateTvShows() : List<TVShow>

}