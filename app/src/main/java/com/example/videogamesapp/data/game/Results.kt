package com.example.videogamesapp.data.game

import com.example.videogamesapp.data.game.detail.EsrbRating
import com.example.videogamesapp.data.game.detail.Platforms
import com.google.gson.annotations.SerializedName

data class Results (

  @SerializedName("id"                 ) var id               : Int?                 = null,
  @SerializedName("slug"               ) var slug             : String?              = null,
  @SerializedName("name"               ) var name             : String?              = null,
  @SerializedName("released"           ) var released         : String?              = null,
  @SerializedName("tba"                ) var tba              : Boolean?             = null,
  @SerializedName("background_image"   ) var backgroundImage  : String?              = null,
  @SerializedName("rating"             ) var rating           : Double?                 = null,
  @SerializedName("rating_top"         ) var ratingTop        : Double?                 = null,
  @SerializedName("ratings_count"      ) var ratingsCount     : Int?                 = null,
  @SerializedName("reviews_text_count" ) var reviewsTextCount : String?              = null,
  @SerializedName("added"              ) var added            : Int?                 = null,
  @SerializedName("metacritic"         ) var metacritic       : Int?                 = null,
  @SerializedName("playtime"           ) var playtime         : Int?                 = null,
  @SerializedName("suggestions_count"  ) var suggestionsCount : Int?                 = null,
  @SerializedName("updated"            ) var updated          : String?              = null,
  @SerializedName("esrb_rating"        ) var esrbRating       : EsrbRating?          = EsrbRating(),
  @SerializedName("platforms"          ) var platforms        : ArrayList<Platforms> = arrayListOf()

)