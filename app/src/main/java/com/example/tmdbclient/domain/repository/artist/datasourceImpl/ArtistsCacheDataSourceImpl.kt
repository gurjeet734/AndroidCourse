package com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl

import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsCacheDataSource
import com.example.tmdbclient.data.model.artist.Artist

class ArtistsCacheDataSourceImpl : ArtistsCacheDataSource {
    private var artistsList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistsList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}