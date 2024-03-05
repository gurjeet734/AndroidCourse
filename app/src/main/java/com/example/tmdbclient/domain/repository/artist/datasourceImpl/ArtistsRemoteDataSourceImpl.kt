package com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsRemoteDataSource
import com.example.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

class ArtistsRemoteDataSourceImpl(private val tmdbService: TMDBService,
                                  private val apiKey : String) : ArtistsRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList>  = tmdbService.getPopularArtists(apiKey)
}