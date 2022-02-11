package com.example.videogamesapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videogamesapp.data.game.Games
import com.example.videogamesapp.data.game.Results
import com.example.videogamesapp.service.Client
import com.example.videogamesapp.service.IRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {
    val gameList: MutableLiveData<List<Results>> = MutableLiveData()

    fun getGameList(): LiveData<List<Results>> {
        return gameList
    }

    fun getData(query: String) {
        val request = Client.getAPIClient().create(IRequest::class.java)
        val call = request.getGameList(query)
        call.enqueue(object:Callback<Games> {
            override fun onResponse(call: Call<Games>, response: Response<Games>) {
                if(response.isSuccessful) {
                    gameList.postValue(response.body()!!.results)
                }
            }

            override fun onFailure(call: Call<Games>, t: Throwable) {
                Log.d("TAG_CUSTOM", t.message.orEmpty())
            }
        })
    }
}