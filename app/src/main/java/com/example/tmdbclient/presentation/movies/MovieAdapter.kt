package com.example.tmdbclient.presentation.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MyMovieViewHolder>() {

    var movieList = ArrayList<Movie>()

    fun setList(list : List<Movie>){
        movieList.clear()
        movieList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieViewHolder {
        val listItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyMovieViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyMovieViewHolder, position: Int) {
        holder.bindView(movieList[position])
    }

}


class MyMovieViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root){
        fun bindView(movie: Movie){
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview

            val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }