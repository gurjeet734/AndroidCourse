package com.example.tmdbclient.data.domain.repository.artist.dataSource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistsLocalDataSource {
    suspend fun getArtists() : List<Artist>
    suspend fun saveArtistsToDB(artistsList : List<Artist>)
    suspend fun clearAll()
}