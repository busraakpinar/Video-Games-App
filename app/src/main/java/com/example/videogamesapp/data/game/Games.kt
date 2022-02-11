package com.example.videogamesapp.data.game

import com.google.gson.annotations.SerializedName


data class Games (

  @SerializedName("count"    ) var count    : Int?               = null,
  @SerializedName("next"     ) var next     : String?            = null,
  @SerializedName("previous" ) var previous : String?            = null,
  @SerializedName("results"  ) var results  : ArrayList<Results> = arrayListOf()

)