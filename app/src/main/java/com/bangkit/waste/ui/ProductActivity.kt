package com.bangkit.waste.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.waste.IngredientsActivity
import com.bangkit.waste.R
import com.bangkit.waste.data.Datasource
import com.bangkit.waste.databinding.ActivityProductBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.squareup.picasso.Picasso

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productId = 0

        val b = intent.extras
        b?.let {
            productId = it.getInt("product_id", 0)
        }
        
        val dataset = Datasource().loadProducts()
        val product = dataset.first { it.id == productId }

        title = product.name
        Picasso.get().load(product.image).into(binding.imageView)
        
        binding.youtubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = product.linkYt
                youTubePlayer.loadVideo(videoId, 0F)
                youTubePlayer.pause()
            }
        })
        
        binding.stepCard.setOnClickListener {
            val sb = Bundle()
            sb.putInt("product_id", productId)

            val i = Intent(this@ProductActivity, StepActivity::class.java)
            i.putExtras(sb)
            
            startActivity(i)
        }
        
        binding.ingredientsCard.setOnClickListener {
            val sb = Bundle()
            sb.putInt("product_id", productId)

            val i = Intent(this@ProductActivity, IngredientsActivity::class.java)
            i.putExtras(sb)
            
            startActivity(i)
        }
        
        binding.ukmCard.setOnClickListener {
            val ub = Bundle()
            ub.putInt("product_id", productId)

            val i = Intent(this@ProductActivity, UkmActivity::class.java)
            i.putExtras(ub)

            startActivity(i)
        }
        
        var isFavorite = checkFavorite(productId)
        if (isFavorite) {
            binding.favoriteButton.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        
        binding.favoriteButton.setOnClickListener { 
            if (isFavorite) {
                removeFavoriteFromPrefs(productId)
                binding.favoriteButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            } else {
                addFavoriteToPrefs(productId)
                binding.favoriteButton.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
            isFavorite = !isFavorite
        }
    }
    
    fun checkFavorite(id: Int): Boolean {
        val sharedPref = getSharedPreferences("waste", Context.MODE_PRIVATE)
        val prefVal = sharedPref.getString("favorites", "") ?: ""
        val favorites = prefVal.split(',')
        
        return favorites.contains(id.toString())
    }
    
    fun addFavoriteToPrefs(id: Int) {
        val sharedPref = getSharedPreferences("waste", Context.MODE_PRIVATE)
        val prefVal = sharedPref.getString("favorites", "") ?: ""
        val favorites = prefVal.split(',')

        if (!favorites.contains(id.toString())) {
            val newFavorites = mutableListOf<String>()
            newFavorites.addAll(favorites)
            newFavorites.add(id.toString())
            
            with(sharedPref.edit()) {
                putString("favorites", newFavorites.joinToString(","))
                apply()
            }
        }
    }    
    
    fun removeFavoriteFromPrefs(id: Int) {
        val sharedPref = getSharedPreferences("waste", Context.MODE_PRIVATE)
        val prefVal = sharedPref.getString("favorites", "") ?: ""
        val favorites = prefVal.split(',')

        if (favorites.contains(id.toString())) {
            val newFavorites = mutableListOf<String>()
            newFavorites.addAll(favorites)
            newFavorites.remove(id.toString())

            with(sharedPref.edit()) {
                putString("favorites", newFavorites.joinToString(","))
                apply()
            }
        }
    }
}