package com.example.videogamesapp.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videogamesapp.data.game.Games
import com.example.videogamesapp.data.game.detail.GameDetail
import com.example.videogamesapp.service.Client
import com.example.videogamesapp.service.IRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameDetailViewModel : ViewModel() {
    private var gameDetail = MutableLiveData<GameDetail>()

    fun getGameDetail(id: Int) {
        val request = Client.getAPIClient().create(IRequest::class.java)
        val call = request.getGameDetail(id)
        call.enqueue(object: Callback<GameDetail> {
            override fun onResponse(call: Call<GameDetail>, response: Response<GameDetail>) {
                if(response.isSuccessful) {
                    gameDetail.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<GameDetail>, t: Throwable) {
                Log.d("TAG_CUSTOM", t.message.orEmpty())
            }
        })
    }

    fun getGameDetail(): LiveData<GameDetail> {
        return gameDetail
    }
}