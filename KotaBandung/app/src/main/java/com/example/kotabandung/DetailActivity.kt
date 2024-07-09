package com.example.kotabandung

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.kotabandung.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tour = intent.getParcelableExtra<Tours>("Tours") as Tours

        binding.photoTour.setImageResource(tour.photo)
        binding.nameTour.text = tour.name
        binding.descTour.text = tour.description

        binding.buttonDirection.setOnClickListener {
            val lat = tour.lat
            val long = tour.long
            val intentUri = Uri.parse("google.navigation:q=$lat,$long")
            val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}