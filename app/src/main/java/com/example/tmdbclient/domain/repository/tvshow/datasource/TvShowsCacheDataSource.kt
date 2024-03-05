package com.example.tmdbclient.data.domain.repository.tvShow.dataSource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.tvshow.TVShow

interface TvShowsCacheDataSource {
    suspend fun getTvShowsFromCache() : List<TVShow>
    suspend fun saveTvShowsToCache(tvShowsList : List<TVShow>)
}