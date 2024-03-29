package com.example.tmdbclient.data.domain.usecase

import com.example.tmdbclient.data.domain.repository.artist.repository.ArtistRepository
import com.example.tmdbclient.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {

    suspend fun execute() : List<Artist>? = artistRepository.updateArtists()

}