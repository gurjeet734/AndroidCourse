package com.example.tmdbclient.data.domain.repository.artist.dataSourceImpl

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.domain.repository.artist.dataSource.ArtistsLocalDataSource
import com.example.tmdbclient.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistsLocalDataSource {
    override suspend fun getArtists(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artistsList: List<Artist>){
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists = artistsList)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}