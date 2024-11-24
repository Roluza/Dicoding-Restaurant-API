package com.example.dicodingrestaurantapi.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingrestaurantapi.R
import com.example.dicodingrestaurantapi.adapter.RestaurantAdapter
import com.example.dicodingrestaurantapi.data.response.RestaurantResponse
import com.example.dicodingrestaurantapi.data.retrofit.ApiConfig
import com.example.dicodingrestaurantapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvRestaurants = binding.rvRestaurants
        rvRestaurants.layoutManager = LinearLayoutManager(this)

        // Fetch data from API
        ApiConfig.getApiService().getRestaurants().enqueue(object : Callback<RestaurantResponse> {
            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                if (response.isSuccessful) {
                    val restaurants = response.body()?.restaurants ?: emptyList()
                    rvRestaurants.adapter = RestaurantAdapter(restaurants)
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("MainActivity", "onFailure: ${t.message}", t)
            }
        })
    }
}