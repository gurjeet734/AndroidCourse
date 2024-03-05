package com.example.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase :: class.java, "tmdbclient").build()
    }

    @Singleton
    @Provides
    fun providesTvShowsDao(tmdbDatabase: TMDBDatabase) : TvShowDao{
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun providesArtistsDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun providesMoviesDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }


}