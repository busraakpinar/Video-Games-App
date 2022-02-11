package com.example.videogamesapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.SearchView
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.example.videogamesapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var isSearching = false
    val searchFragment = MainSearchFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val searchView = findViewById<SearchView>(R.id.searchView)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            if(it.itemId == R.id.ic_baseline_home_24) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainerView, MainFirstFragment())
                transaction.commit()
            }
            if(it.itemId == R.id.ic_baseline_favorite_24) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainerView, MainFavoriteFragment())
                transaction.commit()
            }
            true
        }
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(!query.isNullOrBlank() && query.length > 3) {
                    if(!isSearching) {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.fragmentContainerView, searchFragment)
                        transaction.commit()
                    }
                    searchFragment.searchData(query)
                    isSearching = true
                }
                else if(isSearching) {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, MainFirstFragment())
                    transaction.commit()
                    isSearching = false
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(!newText.isNullOrBlank() && newText.length > 3) {
                    if(!isSearching) {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.fragmentContainerView, searchFragment)
                        transaction.commit()
                    }
                    searchFragment.searchData(newText)
                    isSearching = true
                }
                else if(isSearching) {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, MainFirstFragment())
                    transaction.commit()
                    isSearching = false
                }
                return true
            }
        })
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, MainFirstFragment())
        transaction.commitAllowingStateLoss()
    }
}