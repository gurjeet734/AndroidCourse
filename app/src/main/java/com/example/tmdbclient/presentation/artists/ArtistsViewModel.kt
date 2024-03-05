package com.example.tmdbclient.presentation.artists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclient.data.model.artist.Artist


class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() : LiveData<List<Artist>?> = liveData {
        var listArtist : List<Artist>? = getArtistsUseCase.execute()
        emit(listArtist)
    }

    fun updateArtists() : LiveData<List<Artist>?> = liveData {
        var listArtist : List<Artist>? = updateArtistsUseCase.execute()
        emit(listArtist)
    }


}