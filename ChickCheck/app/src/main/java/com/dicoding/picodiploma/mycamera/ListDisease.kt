package com.dicoding.picodiploma.mycamera

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.mycamera.databinding.ActivityListDiseaseBinding


class ListDisease : AppCompatActivity() {

    companion object {
        val diseaseList = ArrayList<DiseaseResponse>() // List static untuk menyimpan data
    }

    private lateinit var rvDiseases: RecyclerView
    private lateinit var binding: ActivityListDiseaseBinding
    private val list = ArrayList<DiseaseResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDiseaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvDiseases = binding.rvDisease
        rvDiseases.setHasFixedSize(true)
        rvDiseases.layoutManager = LinearLayoutManager(this)
        val adapter = ListDiseaseAdapter(list)
        adapter.addData(diseaseList)
        rvDiseases.adapter = adapter

        // Menginisialisasi tombol add
        val btnAddDisease = binding.btnAddDisease

        // Menangani klik tombol add
        btnAddDisease.setOnClickListener {
            // Kembali ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Ambil data baru dari intent
        val newData = intent.getParcelableArrayListExtra<DiseaseResponse>("EXTRA_DISEASE_LIST")
        val imageUriString = intent.getStringExtra("EXTRA_IMAGE_URI")

        if (newData != null) {
            newData.forEach { disease ->
                disease.Foto = imageUriString // Set Foto untuk setiap disease
                list.add(disease)  // Tambahkan ke list untuk RecyclerView
            }

            // Update static diseaseList juga jika ingin menggunakan shared data
            diseaseList.clear()  // Clear old data
            diseaseList.addAll(list)  // Add all new data to diseaseList

            adapter.notifyDataSetChanged() // Notifikasi perubahan pada adapter
        }

    }

}