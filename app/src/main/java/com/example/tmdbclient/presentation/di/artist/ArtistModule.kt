package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclient.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistsViewModelFactory{
        return ArtistsViewModelFactory(
            getArtistsUseCase, updateArtistsUseCase
        )
    }

}