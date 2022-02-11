package com.example.videogamesapp.db

import com.example.videogamesapp.data.game.Results

class InMemoryDatabase {
    companion object {
        var favoritesList: ArrayList<Results> = arrayListOf()
        var currentGameList: ArrayList<Results> = arrayListOf()
    }
}