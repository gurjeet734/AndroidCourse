package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsCacheDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsLocalDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsRemoteDataSource
import com.example.tmdbclient.data.domain.repository.artist.repository.ArtistRepository
import com.example.tmdbclient.data.domain.repository.artist.repositoryImpl.ArtistsRepositoryImpl
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesCacheDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesLocalDataSource
import com.example.tmdbclient.data.domain.repository.movie.dataSource.MoviesRemoteDataSource
import com.example.tmdbclient.data.domain.repository.movie.repository.MovieRepository
import com.example.tmdbclient.data.domain.repository.movie.repositoryImpl.MoviesRepositoryImpl
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.repository.TvShowsRepository
import com.example.tmdbclient.data.domain.repository.tvShow.repositoryImpl.TvShowsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun providesMoviesRepository(
        moviesRemoteDataSource : MoviesRemoteDataSource,
        moviesCacheDataSource : MoviesCacheDataSource,
        moviesLocalDataSource : MoviesLocalDataSource
    ) : MovieRepository{
        return MoviesRepositoryImpl(
            moviesRemoteDataSource,
            moviesLocalDataSource,
            moviesCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun providesArtistsRepository(
        artistsRemoteDataSource: ArtistsRemoteDataSource,
        artistsLocalDataSource : ArtistsLocalDataSource,
        artistsCacheDataSource : ArtistsCacheDataSource
    ) : ArtistRepository{
        return ArtistsRepositoryImpl(
            artistsRemoteDataSource                                              ,
            artistsLocalDataSource,
            artistsCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun providesTvShowsRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ) : TvShowsRepository{
        return TvShowsRepositoryImpl         (
            tvShowsRemoteDataSource                                              ,
            tvShowsLocalDataSource,
            tvShowsCacheDataSource
        )
    }

//
//    @Singleton
//    @Provides
//    fun providesTvShowsLocalDataSource() : TvShowsCacheDataSource{
//        return TvShowsCacheDataSourceImpl()
//    }
//
//    @Singleton
//    @Provides
//    fun providesArtistsLocalDataSource() : ArtistsCacheDataSource{
//        return  ArtistsCacheDataSourceImpl()
//    }
}