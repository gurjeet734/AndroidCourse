package com.example.tmdbclient.data.domain.repository.tvShow.repositoryImpl

import android.util.Log
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsCacheDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsLocalDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.dataSource.TvShowsRemoteDataSource
import com.example.tmdbclient.data.domain.repository.tvShow.repository.TvShowsRepository
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

import java.lang.Exception

class TvShowsRepositoryImpl(
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TVShow> {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TVShow> {
        var newListOftvShows : List<TVShow> = getTvShowsFromAPI()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOftvShows)
        tvShowsCacheDataSource.saveTvShowsToCache(newListOftvShows)

        return newListOftvShows
    }

    private suspend fun getTvShowsFromAPI() : List<TVShow>{
        lateinit var tvShowsList: List<TVShow>

        try {
            var response : Response<TVShowList> = tvShowsRemoteDataSource.getTvShows()
            var body : TVShowList? = response!!.body()
            if(body != null)
            {
                tvShowsList = body.tvShowList
            }
        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }


        return tvShowsList
    }

    private suspend fun getTvShowsFromDB() : List<TVShow>{
        lateinit var tvShowsList: List<TVShow>

        try {

                tvShowsList = tvShowsLocalDataSource.getTvShows()

        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }

        if(tvShowsList.size > 0) {
            return tvShowsList
        }
        else{
            tvShowsList = getTvShowsFromAPI()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowsList)
        }

        return tvShowsList
    }


    private suspend fun getTvShowsFromCache() : List<TVShow>{
        lateinit var tvShowsList: List<TVShow>

        try {

            tvShowsList = tvShowsCacheDataSource.getTvShowsFromCache()

        }
        catch (exception : Exception){
            Log.e("MYTAG", "ERROR :  ${exception.message}")
        }

        if(tvShowsList.size > 0) {
            return tvShowsList
        }
        else{
            tvShowsList = getTvShowsFromDB()
            tvShowsCacheDataSource.saveTvShowsToCache(tvShowsList)
        }

        return tvShowsList
    }

}