package com.example.tmdbclient.data.domain.repository.tvShow.dataSourceImpl

import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.example.tmdbclient.data.model.tvshow.TVShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowsLocalDataSource {
    override suspend fun getTvShows(): List<TVShow> = tvShowDao.getAllTvShows()

    override suspend fun saveTvShowsToDB(tvShowList: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShowList)
        }
    }

    override suspend fun clearAll(){
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}