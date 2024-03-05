package com.example.tmdbclient.presentation.tvShows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.databinding.ActivityArtistsBinding
import com.example.tmdbclient.databinding.ActivityMoviesBinding
import com.example.tmdbclient.databinding.ActivityTvShowBinding
import com.example.tmdbclient.presentation.artists.ArtistsViewModel
import com.example.tmdbclient.presentation.artists.ArtistsViewModelFactory
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.movies.MovieAdapter
import com.example.tmdbclient.presentation.movies.MoviesViewModel
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    private lateinit var adapter: TvShowAdapter

    @Inject
    lateinit var factory: TvShowsViewModelFactory
    private lateinit var tvShowsViewModel: TvShowsViewModel
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createTvShowsSubComponent().inject(this)

        tvShowsViewModel = ViewModelProvider(this, factory).get(TvShowsViewModel :: class.java)

        initRecyclerView()
    }

    fun initRecyclerView(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayTvShows()
    }

    private fun displayTvShows() {
        val responseData : LiveData<List<TVShow>?> = tvShowsViewModel.getTvShows()
        responseData.observe(this, Observer {
            if(it != null) {
                binding.tvShowProgressBar.visibility = View.GONE
                adapter.setList(it!!)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    private fun updateTvShows() {
        val responseData : LiveData<List<TVShow>?> = tvShowsViewModel.updateTvShows()
        responseData.observe(this, Observer {
            if(it != null) {
                binding.tvShowProgressBar.visibility = View.GONE
                adapter.setList(it!!)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update ->{
                updateTvShows()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}