package com.example.kotabandung

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Culinary(
    var name: String,
    var description: String,
    var photo: Int,
    var lat: Double,
    var long: Double
) : Parcelable
