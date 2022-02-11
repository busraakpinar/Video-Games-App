package com.example.videogamesapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.videogamesapp.R
import com.example.videogamesapp.data.game.Results
import com.example.videogamesapp.databinding.ImageItemBinding
import com.example.videogamesapp.ui.detail.GameDetailActivity
import java.util.ArrayList

class GamePhotosPagerAdapter(context: Context) : RecyclerView.Adapter<GamePhotosPagerAdapter.ViewHolder>() {
    var context = context
    var list: ArrayList<String> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamePhotosPagerAdapter.ViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamePhotosPagerAdapter.ViewHolder, position: Int) {
        var item: String = list[position]
        if(!TextUtils.isEmpty(item)) {
            Glide.with(context).load(item).into(holder.binding.imageViewMain)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapterList(games: List<String>) {
        list.addAll(games)
        Log.d("addAll worked", games.size.toString())
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: ImageItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: ImageItemBinding = itemView
    }
}