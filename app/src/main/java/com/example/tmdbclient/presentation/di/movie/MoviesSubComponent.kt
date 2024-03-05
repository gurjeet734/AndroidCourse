package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.presentation.artists.ArtistsActivity
import com.example.tmdbclient.presentation.movies.MoviesActivity
import dagger.Subcomponent


@MoviesScope
@Subcomponent(modules = [MoviesModule :: class])
interface MoviesSubComponent {

    fun inject(moviesActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create() : MoviesSubComponent
        
    }
    
}