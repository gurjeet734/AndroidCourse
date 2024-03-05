package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.presentation.artists.ArtistsActivity
import com.example.tmdbclient.presentation.tvShows.TvShowActivity
import dagger.Module
import dagger.Subcomponent


@TvShowsScope
@Subcomponent(modules = [TvShowsModule :: class])
interface TvShowsSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create() : TvShowsSubComponent
        
    }
    
}