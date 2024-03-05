package com.example.tmdbclient.presentation.di.core

import android.content.Context
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowsSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MoviesSubComponent :: class, TvShowsSubComponent :: class, ArtistSubComponent :: class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext() : Context {
        return context.applicationContext
    }


}