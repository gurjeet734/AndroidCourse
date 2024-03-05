package com.example.tmdbclient.presentation.artists

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
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ActivityArtistsBinding
import com.example.tmdbclient.databinding.ActivityMoviesBinding
import com.example.tmdbclient.presentation.di.Injector
import com.example.tmdbclient.presentation.movies.MovieAdapter
import com.example.tmdbclient.presentation.movies.MoviesViewModel
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    private lateinit var adapter: ArtistAdapter


    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var artistsViewModel: ArtistsViewModel
    private lateinit var binding: ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createArtistsSubComponent().inject(this)

        artistsViewModel = ViewModelProvider(this, factory).get(ArtistsViewModel :: class.java)

        initRecyclerView()
    }

    fun initRecyclerView(){
        binding.artistProgressBar.visibility = View.VISIBLE
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayArtists()
    }

    private fun displayArtists() {
        val responseData : LiveData<List<Artist>?> = artistsViewModel.getArtists()
        responseData.observe(this, Observer {
            if(it != null) {
                binding.artistProgressBar.visibility = View.GONE
                adapter.setList(it!!)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    private fun updateArtists() {
        val responseData : LiveData<List<Artist>?> = artistsViewModel.updateArtists()
        responseData.observe(this, Observer {
            if(it != null) {
                binding.artistProgressBar.visibility = View.GONE
                adapter.setList(it!!)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update ->{
                updateArtists()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}