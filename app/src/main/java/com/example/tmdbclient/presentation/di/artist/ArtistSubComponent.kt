package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.presentation.artists.ArtistsActivity
import dagger.Module
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule :: class])
interface ArtistSubComponent {

    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create() : ArtistSubComponent
        
    }
    
}