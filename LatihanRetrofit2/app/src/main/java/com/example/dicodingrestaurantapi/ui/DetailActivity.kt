package com.example.dicodingrestaurantapi.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.dicodingrestaurantapi.R
import com.example.dicodingrestaurantapi.data.response.RestaurantsItem
import com.example.dicodingrestaurantapi.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari intent
        val restaurant = intent.getParcelableExtra<RestaurantsItem>("EXTRA_RESTAURANT")

        // Bind data ke view
        restaurant?.let {
            binding.tvDetailName.text = it.name
            binding.tvDetailCity.text = "City: ${it.city}"
            binding.tvDetailRating.text = "Rating: ${it.rating}"
            binding.tvDetailDescription.text = it.description

            Glide.with(this)
                .load("https://restaurant-api.dicoding.dev/images/medium/${it.pictureId}")
                .into(binding.ivDetailImage)
        }
    }
}