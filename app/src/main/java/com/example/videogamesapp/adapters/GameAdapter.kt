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
import com.example.videogamesapp.databinding.GameItemBinding
import com.example.videogamesapp.ui.detail.GameDetailActivity
import java.util.ArrayList

class GameAdapter(context: Context) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    var context = context
    var list: List<Results> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item: Results = list[position]
        if(!TextUtils.isEmpty(item.backgroundImage)) {
            Glide.with(context).load(item.backgroundImage).into(holder.binding.imageViewGame)
        }
        holder.binding.tvName.setText(item.name)
        holder.binding.tvRatingAndRelease.setText(context.resources.getString(R.string.ratings_and_release_string, item.rating, item.released))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAdapterList(games: List<Results>) {
        list = games
        Log.d("addAll worked", games.size.toString())
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: GameItemBinding) : RecyclerView.ViewHolder(itemView.root), View.OnClickListener {
        var binding: GameItemBinding = itemView

        init {
            binding.root.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val detailPageIntent = Intent(context, GameDetailActivity::class.java)
            detailPageIntent.putExtra("id", list[adapterPosition].id!!)
            context.startActivity(detailPageIntent)
        }

    }
}