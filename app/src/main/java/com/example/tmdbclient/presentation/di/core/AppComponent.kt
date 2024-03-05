package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowsSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule :: class,
    CacheDataModule :: class,
    DatabaseModule :: class,
    LocalDataModule :: class,
    NetModule :: class,
    RemoteDataModule :: class,
    RepositoryModule :: class,
    UseCaseModule :: class
])
interface AppComponent {

    fun moviesSubComponent() : MoviesSubComponent.Factory
    fun tvShowsSubComponent() : TvShowsSubComponent.Factory
    fun artistsSubComponent() : ArtistSubComponent.Factory

}