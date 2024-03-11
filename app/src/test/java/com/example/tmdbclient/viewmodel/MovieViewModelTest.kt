package com.example.tmdbclient.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tmdbclient.data.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.data.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.FakeMovieRepository
import com.example.tmdbclient.getOrAwaitValue
import com.example.tmdbclient.presentation.movies.MoviesViewModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieViewModelTest {
    private lateinit var movies : List<Movie>
    private lateinit var moviesViewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        moviesViewModel = MoviesViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()

        movies.add(Movie(1,"overview1","posterPath1","date1","title1"))
        movies.add(Movie(2,"overview2","posterPath2","date2","title2"))
        movies.add(Movie(3,"overview3","posterPath3","date3","title3"))

        val currentList: List<Movie>? = moviesViewModel.getMovies().getOrAwaitValue()

        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()

        movies.add(Movie(4,"overview4","posterPath4","date4","title4"))
        movies.add(Movie(5,"overview5","posterPath5","date5","title5"))
        movies.add(Movie(6,"overview6","posterPath6","date6","title6"))

        val currentList: List<Movie>? = moviesViewModel.getMovies().getOrAwaitValue()

        assertThat(currentList).isEqualTo(movies)
    }


}