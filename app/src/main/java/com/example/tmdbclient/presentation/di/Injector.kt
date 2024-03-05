package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowsSubComponent

interface Injector {

    fun createArtistsSubComponent() : ArtistSubComponent
    fun createTvShowsSubComponent() : TvShowsSubComponent
    fun createMoviesSubComponent() : MoviesSubComponent

}
