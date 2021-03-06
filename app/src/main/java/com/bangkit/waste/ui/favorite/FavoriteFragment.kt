package com.bangkit.waste.ui.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.waste.R
import com.bangkit.waste.adapter.ProductAdapter
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private var _binding: FragmentFavoriteBinding? = null
    private var isCreated = false

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        favoriteViewModel =
            ViewModelProvider(this).get(FavoriteViewModel::class.java)

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateDataset()
        isCreated = true
    }

    override fun onResume() {
        super.onResume()
        
        if (isCreated) updateDataset()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    fun updateDataset() {
        val sharedPref = requireContext().getSharedPreferences("waste", Context.MODE_PRIVATE)
        val prefVal = sharedPref.getString("favorites", "") ?: ""
        val favorites = prefVal.split(',')

        val favoriteDataset = Datasource().loadProducts().filter {
            favorites.contains(it.id.toString())
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ProductAdapter(requireContext(), favoriteDataset)
        }
    }
}