package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsRemoteDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl.ArtistsRemoteDataSourceImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesRemoteDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl.TvShowsRemoteDataSourceImpl
import com.example.tmdbclient.presentation.tvShows.TvShowsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private  val apiKey : String) {

    @Singleton
    @Provides
    fun providesMoviesDataSource(tmdbService: TMDBService) : MoviesRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesTvShowsDataSource(tmdbService: TMDBService) : TvShowsRemoteDataSource{
        return TvShowsRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesArtistsDataSource(tmdbService: TMDBService) : ArtistsRemoteDataSource{
        return ArtistsRemoteDataSourceImpl(tmdbService, apiKey)
    }


}