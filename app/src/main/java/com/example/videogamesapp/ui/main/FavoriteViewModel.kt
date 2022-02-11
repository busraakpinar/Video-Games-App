package com.example.videogamesapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videogamesapp.data.game.Games
import com.example.videogamesapp.data.game.Results
import com.example.videogamesapp.db.InMemoryDatabase
import com.example.videogamesapp.service.Client
import com.example.videogamesapp.service.IRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteViewModel : ViewModel() {
    private val gameList: MutableLiveData<List<Results>> = MutableLiveData()

    fun getGameList(): LiveData<List<Results>> {
        return gameList
    }

    fun getData() {
        gameList.postValue(InMemoryDatabase.favoritesList)
    }
}