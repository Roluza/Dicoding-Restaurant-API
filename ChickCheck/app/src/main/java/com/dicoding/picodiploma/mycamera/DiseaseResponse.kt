package com.dicoding.picodiploma.mycamera

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DiseaseResponse(
    val Penyakit: String ?,
    val Deskripsi: String ?,
    val Penanganan: String ?,
    val Gejala: String ?,
    var Foto: String ?
) : Parcelable
