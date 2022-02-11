package com.example.videogamesapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.videogamesapp.R
import com.example.videogamesapp.adapters.GameAdapter
import com.example.videogamesapp.adapters.GamePhotosPagerAdapter
import com.example.videogamesapp.data.game.Results
import com.example.videogamesapp.databinding.MainViewBinding
import com.example.videogamesapp.db.InMemoryDatabase
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class MainFirstFragment : Fragment() {

    private lateinit var gameAdapter: GameAdapter
    private lateinit var gamePhotosPagerAdapter: GamePhotosPagerAdapter
    private lateinit var binding: MainViewBinding

    private lateinit var mViewModel: FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainViewBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)
        mViewModel.getData()
        initComponents()
        initObservers()
    }

    private fun initComponents() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        gameAdapter = GameAdapter(requireActivity())
        gamePhotosPagerAdapter = GamePhotosPagerAdapter(requireActivity())
        binding.recyclerView.adapter = gameAdapter
        binding.viewPagerMain.adapter = gamePhotosPagerAdapter

    }

    private fun initObservers() {
        mViewModel.getGameList().observe(requireActivity(), this::prepareRecycler)
    }

    private fun prepareRecycler(games: List<Results>) {
        gameAdapter.setAdapterList(games)
        InMemoryDatabase.currentGameList.clear()
        InMemoryDatabase.currentGameList.addAll(games)
        var photoList = ArrayList<String>()
        games.take(3).forEach {
            it.backgroundImage?.let { it1 -> photoList.add(it1) }
        }
        gamePhotosPagerAdapter.setAdapterList(photoList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}