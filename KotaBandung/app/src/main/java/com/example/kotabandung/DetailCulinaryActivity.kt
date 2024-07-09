package com.example.kotabandung

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.kotabandung.databinding.ActivityDetailCulinaryBinding

class DetailCulinaryActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityDetailCulinaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCulinaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val culinary = intent.getParcelableExtra<Tours>("Culinary") as Culinary

        binding.photoCulinary.setImageResource(culinary.photo)
        binding.nameCulinary.text = culinary.name
        binding.descCulinary.text = culinary.description

        binding.buttonDirection.setOnClickListener {
            val lat = culinary.lat
            val long = culinary.long
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