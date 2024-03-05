package com.example.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }

}