package com.example.kotabandung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.example.kotabandung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconWeather.setOnClickListener {
            intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
        }

        binding.iconTour.setOnClickListener {
            intent = Intent(this, TourActivity::class.java)
            startActivity(intent)
        }

        binding.iconMaps.setOnClickListener {
            intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        binding.iconCity.setOnClickListener {
            intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding.iconCulinary.setOnClickListener {
            intent = Intent(this, CulinaryActivity::class.java)
            startActivity(intent)
        }

        binding.iconTentang.setOnClickListener {
            intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Dark Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Light Mode")
        menu?.add(Menu.NONE, 3 , Menu.NONE, "Follow by system")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
        return super.onOptionsItemSelected(item)
    }
}