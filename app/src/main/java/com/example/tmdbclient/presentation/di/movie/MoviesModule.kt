package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.presentation.artists.ArtistsViewModelFactory
import com.example.tmdbclient.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MoviesModule {

    @MoviesScope
    @Provides
    fun providesMoviesViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MoviesViewModelFactory{
        return MoviesViewModelFactory(
            getMoviesUseCase, updateMoviesUseCase)
    }

}