package com.dicoding.picodiploma.mycamera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.mycamera.databinding.ActivityDetailDiseaseBinding


class DetailDisease : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDiseaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDiseaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menginisialisasi Toolbar dan set sebagai ActionBar
        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)

        // Menambahkan tombol back (up button) pada toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Menangani klik tombol back menggunakan OnBackPressedDispatcher
        toolbar.setNavigationOnClickListener {
            // Menggunakan OnBackPressedDispatcher untuk menangani aksi tombol kembali
            onBackPressedDispatcher.onBackPressed()
        }

        // Menerima data yang dikirim dari RecyclerView
        val disease = intent.getParcelableExtra<DiseaseResponse>("DISEASE_DATA")

        // Gabungkan data penyakit, deskripsi, penanganan, dan gejala menjadi satu string
        disease?.let {
            val combinedInfo = """
                Penyakit: ${it.Penyakit}
                
                Deskripsi: ${it.Deskripsi}
                
                Penanganan: ${it.Penanganan}
                
                Gejala: ${it.Gejala}
            """.trimIndent()

            // Menampilkan data di satu TextView
            binding.tvDescription.text = combinedInfo

            // Menampilkan nama penyakit
            binding.tvDiseaseName.text = it.Penyakit

            // Menampilkan gambar penyakit menggunakan Glide
            Glide.with(this)
                .load(it.Foto)  // Memuat gambar menggunakan Glide
                .into(binding.imageDisease)
        }

    }
}