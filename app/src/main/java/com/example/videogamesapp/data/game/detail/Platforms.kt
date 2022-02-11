package com.example.videogamesapp.data.game.detail

import com.google.gson.annotations.SerializedName


data class Platforms (

  @SerializedName("platform"     ) var platform     : Platform?     = Platform(),
  @SerializedName("released_at"  ) var releasedAt   : String?       = null,
  @SerializedName("requirements" ) var requirements : Requirements? = Requirements()

)