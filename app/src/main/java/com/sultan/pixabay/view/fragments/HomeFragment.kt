package com.sultan.pixabay.view.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sultan.pixabay.R
import com.sultan.pixabay.databinding.FragmentHomeBinding
import com.sultan.pixabay.view.adapters.ImageAdapter
import com.sultan.pixabay.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel : HomeViewModel by viewModels()
    private val adapter = ImageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getImages(q = "image")
        initialize()
    }

    private fun initialize() {
        initializeAdapter()
        initializeObserver()
        setupListeners()
    }

    private fun initializeAdapter() {
        binding.imageRecyclerView.adapter = adapter
    }

    private fun initializeObserver() {
        viewModel.image.observe(viewLifecycleOwner) { images ->
            adapter.submitList(images.hits)
        }
    }

    private fun setupListeners() = with(binding) {
        searchImageView.setOnClickListener {
            val searchText = searchEditText.text.toString()
            viewModel.getImages(searchText)
        }
    }

}