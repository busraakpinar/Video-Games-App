package com.example.videogamesapp.data.game.detail

import com.google.gson.annotations.SerializedName


data class Platform (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("slug" ) var slug : String? = null,
  @SerializedName("name" ) var name : String? = null

)