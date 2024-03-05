package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsLocalDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl.ArtistsLocalDataSourceImpl
import com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl.ArtistsRemoteDataSourceImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesLocalDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl.MoviesLocalDataSourceImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl.TvShowsLocalDataSourceImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl.TvShowsRemoteDataSourceImpl
import com.example.tmdbclient.presentation.tvShows.TvShowsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesMoviesLocalDataSource(movieDao: MovieDao) : MoviesLocalDataSource{
        return MoviesLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providesTvShowsLocalDataSource(tvShowDao: TvShowDao) : TvShowsLocalDataSource{
        return TvShowsLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun providesArtistsLocalDataSource(artistDao: ArtistDao) : ArtistsLocalDataSource{
        return ArtistsLocalDataSourceImpl(artistDao)
    }
}