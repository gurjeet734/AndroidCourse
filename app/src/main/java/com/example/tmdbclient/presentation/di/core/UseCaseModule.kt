package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.domain.repository.artist.repository.ArtistRepository
import com.example.tmdbclient.data.domain.repository.movie.repository.MovieRepository
import com.example.tmdbclient.data.domain.repository.tvShow.repository.TvShowsRepository
import com.example.tmdbclient.data.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesUpdateMoviesUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun providesGetArtistsUseCase(artistRepository: ArtistRepository) : GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun providesUpdateArtistsUseCase(artistRepository: ArtistRepository) : UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }

    @Provides
    fun providesGetTvShowsUseCase(tvShowsRepository: TvShowsRepository) : GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun providesUpdateTvShowsUseCase(tvShowsRepository: TvShowsRepository) : UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

}