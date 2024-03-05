package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbclient.presentation.artists.ArtistsViewModelFactory
import com.example.tmdbclient.presentation.movies.MoviesViewModelFactory
import com.example.tmdbclient.presentation.tvShows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowsModule {

    @TvShowsScope
    @Provides
    fun providesTvShowsViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowsViewModelFactory {
        return TvShowsViewModelFactory(
            getTvShowsUseCase, updateTvShowsUseCase)
    }

}