package com.example.videogamesapp.data.game.detail

import com.google.gson.annotations.SerializedName


data class MetacriticPlatforms (

  @SerializedName("metascore" ) var metascore : Int?    = null,
  @SerializedName("url"       ) var url       : String? = null

)