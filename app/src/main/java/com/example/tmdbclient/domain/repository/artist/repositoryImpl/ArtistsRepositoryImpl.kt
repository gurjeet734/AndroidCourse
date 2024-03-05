package com.example.tmdbclient.data.domain.repository.artist.repositoryImpl

import android.util.Log
import com.example.tmdbclient.data.domain.repository.artist.repository.ArtistRepository
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsCacheDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsLocalDataSource
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsRemoteDataSource
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

import java.lang.Exception

class ArtistsRepositoryImpl(
    private val artistsRemoteDataSource: ArtistsRemoteDataSource,
    private val artistsLocalDataSource: ArtistsLocalDataSource,
    private val artistsCacheDataSource: ArtistsCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist> {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist> {
        var newListOfArtists : List<Artist> = getArtistsFromAPI()
        artistsLocalDataSource.clearAll()
        artistsLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistsCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    private suspend fun getArtistsFromAPI() : List<Artist>{
        lateinit var artistsList : List<Artist>

        try {
            var response : Response<ArtistList> = artistsRemoteDataSource.getArtists()
            var body : ArtistList? = response!!.body()
            if(body != null)
            {
                artistsList = body.results
            }
        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }


        return artistsList
    }

    private suspend fun getArtistsFromDB() : List<Artist>{
        lateinit var artistsList: List<Artist>

        try {

                artistsList = artistsLocalDataSource.getArtists()

        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }

        if(artistsList.isNotEmpty()) {
            return artistsList
        }
        else{
            artistsList = getArtistsFromAPI()
            artistsLocalDataSource.saveArtistsToDB(artistsList)
        }

        return artistsList
    }


    private suspend fun getArtistsFromCache() : List<Artist>{
        lateinit var artistsList : List<Artist>

        try {

            artistsList = artistsCacheDataSource.getArtistsFromCache()

        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }

        if(artistsList.isNotEmpty()) {
            return artistsList
        }
        else{
            artistsList = getArtistsFromDB()
            artistsCacheDataSource.saveArtistsToCache(artistsList)
        }

        return artistsList
    }

}