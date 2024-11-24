package com.example.dicodingrestaurantapi.data.retrofit

import com.example.dicodingrestaurantapi.data.response.RestaurantResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("list")
    fun getRestaurants(): Call<RestaurantResponse>
}