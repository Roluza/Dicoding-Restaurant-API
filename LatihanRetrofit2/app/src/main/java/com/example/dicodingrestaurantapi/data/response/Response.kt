package com.example.dicodingrestaurantapi.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class RestaurantResponse(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("restaurants")
	val restaurants: List<RestaurantsItem?>? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

@Parcelize
data class RestaurantsItem(

	@field:SerializedName("pictureId")
	val pictureId: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable
