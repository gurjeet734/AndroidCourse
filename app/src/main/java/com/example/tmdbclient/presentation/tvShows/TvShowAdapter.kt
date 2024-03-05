package com.example.tmdbclient.presentation.tvShows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<MyTvShowViewHolder>() {

    var tvShowsList = ArrayList<TVShow>()

    fun setList(list : List<TVShow>){
        tvShowsList.clear()
        tvShowsList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTvShowViewHolder {
        val listItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyTvShowViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return tvShowsList.size
    }

    override fun onBindViewHolder(holder: MyTvShowViewHolder, position: Int) {
        holder.bindView(tvShowsList[position])
    }

}


class MyTvShowViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root){
        fun bindView(tvShow: TVShow){
            binding.titleTextView.text = tvShow.name
            binding.descriptionTextView.text = tvShow.overview

            val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }