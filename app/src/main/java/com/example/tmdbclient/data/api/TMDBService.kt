package com.example.tmdbclient.data.api

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")api_key : String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key")api_key : String) : Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")api_key : String) : Response<ArtistList>

}