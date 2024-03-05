package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsCacheDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl.ArtistsCacheDataSourceImpl
import com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl.ArtistsLocalDataSourceImpl
import com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl.ArtistsRemoteDataSourceImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesCacheDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl.MoviesCacheDataSourceImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSourceImpl.MoviesLocalDataSourceImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl.TvShowsCacheDataSourceImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl.TvShowsLocalDataSourceImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl.TvShowsRemoteDataSourceImpl
import com.example.tmdbclient.presentation.tvShows.TvShowsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesMoviesLocalDataSource() : MoviesCacheDataSource{
        return MoviesCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowsLocalDataSource() : TvShowsCacheDataSource{
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistsLocalDataSource() : ArtistsCacheDataSource{
        return ArtistsCacheDataSourceImpl()
    }
}