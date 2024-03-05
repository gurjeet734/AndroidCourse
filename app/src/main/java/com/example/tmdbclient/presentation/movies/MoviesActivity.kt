package com.example.tmdbclient.presentation.movies

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
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.databinding.ActivityMoviesBinding
import com.example.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    private lateinit var adapter: MovieAdapter

    @Inject
    lateinit var factory: MoviesViewModelFactory
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var binding: ActivityMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMoviesSubComponent().inject(this)

        moviesViewModel = ViewModelProvider(this, factory).get(MoviesViewModel :: class.java)
        initRecyclerView()
    }

    fun initRecyclerView(){
        binding.movieProgressBar.visibility = View.VISIBLE
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayMovies()
    }

    private fun displayMovies() {
        val responseData : LiveData<List<Movie>?> = moviesViewModel.getMovies()
        responseData.observe(this, Observer {
            if(it != null) {
                binding.movieProgressBar.visibility = View.GONE
                adapter.setList(it!!)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    private fun updateMovies() {
        val responseData : LiveData<List<Movie>?> = moviesViewModel.updateMovies()
        responseData.observe(this, Observer {
            if(it != null) {
                binding.movieProgressBar.visibility = View.GONE
                adapter.setList(it!!)
                adapter.notifyDataSetChanged()
            }
            else
            {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.update ->{
                updateMovies()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}