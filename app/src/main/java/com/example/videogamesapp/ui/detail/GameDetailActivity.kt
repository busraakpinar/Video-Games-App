package com.example.videogamesapp.ui.detail

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.TextView
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.videogamesapp.R
import com.example.videogamesapp.data.game.detail.GameDetail
import com.example.videogamesapp.databinding.ActivityGameDetailBinding
import com.example.videogamesapp.db.InMemoryDatabase

class GameDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityGameDetailBinding
    lateinit var mViewModel: GameDetailViewModel
    var id = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(GameDetailViewModel::class.java)
        mViewModel.getGameDetail().observe(this, this::prepareView)

        // Get id from intent and request for data
        var extras = intent.extras
        if(extras != null && extras.containsKey("id")) {
            id = extras.getInt("id")
            mViewModel.getGameDetail(id)
            Log.d("FOUND", "Data found from id in intent extras")
        }
    }

    fun textHelper(text: String?, textView: TextView) {
        if(!TextUtils.isEmpty(text))
            textView.setText(text)
    }

    fun prepareView(detail: GameDetail) {
        textHelper(detail.name, binding.textViewName)
        textHelper(detail.released, binding.textViewReleaseDate)
        textHelper(detail.metacritic.toString(), binding.textViewMetacriticRate)
        textHelper(detail.descriptionRaw, binding.textViewDescription)
        if(!TextUtils.isEmpty(detail.backgroundImage))
            Glide.with(this).load(detail.backgroundImage).into(binding.imageViewGameDetail)
        binding.buttonLike.setOnClickListener {
            val data = InMemoryDatabase.currentGameList.find {
                it.id == id
            }
            if(data != null)
                InMemoryDatabase.favoritesList.add(data)
        }
    }
}