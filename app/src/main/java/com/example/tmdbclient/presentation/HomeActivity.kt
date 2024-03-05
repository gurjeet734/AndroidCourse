package com.example.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbclient.databinding.ActivityHomeBinding
import com.example.tmdbclient.presentation.artists.ArtistsActivity
import com.example.tmdbclient.presentation.movies.MoviesActivity
import com.example.tmdbclient.presentation.tvShows.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.artistsButton.setOnClickListener {
            var intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }

        binding.movieButton.setOnClickListener {
            var intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            var intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}