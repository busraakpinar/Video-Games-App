package com.example.videogamesapp.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videogamesapp.R
import com.example.videogamesapp.adapters.GameAdapter
import com.example.videogamesapp.adapters.GamePhotosPagerAdapter
import com.example.videogamesapp.data.game.Results
import com.example.videogamesapp.databinding.FragmentMainFavoriteBinding
import com.example.videogamesapp.databinding.FragmentMainSearchBinding
import com.example.videogamesapp.databinding.MainViewBinding

class MainFavoriteFragment : Fragment() {
    private lateinit var gameAdapter: GameAdapter
    private lateinit var binding: FragmentMainFavoriteBinding

    private lateinit var mViewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMainFavoriteBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        mViewModel.getData()
        initComponents()
        initObservers()
    }

    private fun initComponents() {
        binding.recyclerViewFavorite.apply {
            layoutManager = LinearLayoutManager(requireActivity())
        }
        binding.recyclerViewFavorite.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerViewFavorite.itemAnimator = DefaultItemAnimator()
        gameAdapter = GameAdapter(requireActivity())
        binding.recyclerViewFavorite.adapter = gameAdapter
    }

    private fun initObservers() {
        mViewModel.getGameList().observe(requireActivity(), this::prepareRecycler)
    }

    private fun prepareRecycler(games: List<Results>) {
        gameAdapter.setAdapterList(games)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}