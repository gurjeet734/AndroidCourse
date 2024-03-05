package com.example.tmdbclient.presentation

import android.app.Application
import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.tmdbclient.presentation.di.core.AppComponent
import com.example.tmdbclient.presentation.di.core.AppModule
import com.example.tmdbclient.presentation.di.core.DaggerAppComponent
import com.example.tmdbclient.presentation.di.core.NetModule
import com.example.tmdbclient.presentation.di.core.RemoteDataModule
import com.example.tmdbclient.presentation.di.movie.MoviesSubComponent
import com.example.tmdbclient.presentation.di.tvShow.TvShowsSubComponent

class App : Injector, Application() {

    private lateinit var appComponent: AppComponent



    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }


    override fun createArtistsSubComponent(): ArtistSubComponent {
        return appComponent.artistsSubComponent().create()
    }

    override fun createTvShowsSubComponent(): TvShowsSubComponent {
        return appComponent.tvShowsSubComponent().create()
    }

    override fun createMoviesSubComponent(): MoviesSubComponent {
        return appComponent.moviesSubComponent().create()
    }
}