package com.example.tmdbclient.presentation.tvShows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.data.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }

}