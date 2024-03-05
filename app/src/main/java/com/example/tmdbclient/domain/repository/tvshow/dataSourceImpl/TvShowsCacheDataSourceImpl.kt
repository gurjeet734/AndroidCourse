package com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl

import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.example.tmdbclient.data.model.tvshow.TVShow

class TvShowsCacheDataSourceImpl : TvShowsCacheDataSource {
    private var tvShowsList = ArrayList<TVShow>()

    override suspend fun getTvShowsFromCache(): List<TVShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TVShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}