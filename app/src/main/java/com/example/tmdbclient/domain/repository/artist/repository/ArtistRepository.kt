package com.example.tmdbclient.data.domain.repository.artist.repository

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>

    suspend fun updateArtists() : List<Artist>

}