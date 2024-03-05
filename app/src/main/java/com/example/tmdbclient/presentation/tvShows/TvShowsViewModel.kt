package com.example.tmdbclient.presentation.tvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbclient.data.model.tvshow.TVShow

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() : LiveData<List<TVShow>?> = liveData {
        var listTvShow : List<TVShow>? = getTvShowsUseCase.execute()
        emit(listTvShow)
    }

    fun updateTvShows() : LiveData<List<TVShow>?> = liveData {
        var listTvShow : List<TVShow>? = updateTvShowsUseCase.execute()
        emit(listTvShow)
    }


}