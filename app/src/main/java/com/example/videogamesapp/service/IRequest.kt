package com.example.videogamesapp.service

import com.example.videogamesapp.data.game.Games
import com.example.videogamesapp.data.game.detail.GameDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRequest {
    @GET("games?key=5a6b8e2b1c2a4decb5363b5d5b5dba8d")
    fun getGameList(@Query("search") query: String = ""): Call<Games>

    @GET("games/{id}?key=5a6b8e2b1c2a4decb5363b5d5b5dba8d")
    fun getGameDetail(@Path("id") id:Int): Call<GameDetail>

}