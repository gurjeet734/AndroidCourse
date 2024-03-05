package com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                  private val apiKey : String) : TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TVShowList> = tmdbService.getPopularTVShows(apiKey)
}