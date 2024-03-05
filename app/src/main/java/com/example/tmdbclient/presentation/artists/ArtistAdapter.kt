package com.example.tmdbclient.presentation.artists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<MyArtistViewHolder>() {

    var artistList = ArrayList<Artist>()

    fun setList(list : List<Artist>){
        artistList.clear()
        artistList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyArtistViewHolder {
        val listItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MyArtistViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyArtistViewHolder, position: Int) {
        holder.bindView(artistList[position])
    }

}


class MyArtistViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root){
        fun bindView(artist: Artist){
            binding.titleTextView.text = artist.name
            binding.descriptionTextView.visibility = View.GONE

            val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath

            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)
        }
    }