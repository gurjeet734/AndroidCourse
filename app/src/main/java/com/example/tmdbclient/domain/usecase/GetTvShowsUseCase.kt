package com.example.tmdbclient.data.domain.usecase

import com.example.tmdbclient.data.domain.repository.tvShow.repository.TvShowsRepository
import com.example.tmdbclient.data.model.tvshow.TVShow

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute() : List<TVShow>? = tvShowsRepository.getTvShows()

}