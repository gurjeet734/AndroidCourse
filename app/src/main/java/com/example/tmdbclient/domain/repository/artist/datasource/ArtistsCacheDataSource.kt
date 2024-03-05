package com.example.tmdbclient.data.domain.repository.artist.dataSource

import com.example.tmdbclient.data.model.artist.Artist

interface ArtistsCacheDataSource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)
}