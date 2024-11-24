package com.example.dicodingrestaurantapi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingrestaurantapi.data.response.RestaurantsItem
import com.example.dicodingrestaurantapi.databinding.ItemRestaurantBinding
import com.example.dicodingrestaurantapi.ui.DetailActivity

class RestaurantAdapter(private val restaurants: List<RestaurantsItem?>) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(private val binding: ItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: RestaurantsItem) {
            with(binding) {
                tvName.text = restaurant.name
                tvCity.text = "City: ${restaurant.city}"
                tvRating.text = "Rating: ${restaurant.rating}"

                // Load image with Glide
                Glide.with(root.context)
                    .load("https://restaurant-api.dicoding.dev/images/medium/${restaurant.pictureId}")
                    .into(ivRestaurant)

                // Tambahkan OnClickListener langsung di sini
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("EXTRA_RESTAURANT", restaurant) // Kirim data via Parcelable
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ItemRestaurantBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        restaurants[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = restaurants.size
}