package com.example.tmdbclient.data.domain.repository.artist.dataSource

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistsRemoteDataSource {
    suspend fun getArtists() : Response<ArtistList>
}