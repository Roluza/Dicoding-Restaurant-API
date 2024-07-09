package com.example.kotabandung

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TourActivity : AppCompatActivity() {

    private lateinit var rvTours: RecyclerView
    private val list = ArrayList<Tours>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tour)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        rvTours = findViewById(R.id.rv_tours)
        rvTours.setHasFixedSize(true)

        list.addAll(listTours)
        showRecyclerList()
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

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvTours.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvTours.layoutManager = LinearLayoutManager(this)
        }
        val listTourAdapter = ListTourAdapter(list)
        rvTours.adapter = listTourAdapter

    }

    private val latTour = doubleArrayOf(-7.141133, -7.166018, -6.805889, -6.832904, -6.780420)
    private val longTour = doubleArrayOf(107.395703, 107.403275, 107.591978, 107.604095, 107.637500)

    private val listTours: ArrayList<Tours>
        get() {
            val tourName = resources.getStringArray(R.array.tour_name)
            val tourPhoto = resources.obtainTypedArray(R.array.photo_tour)
            val tourDesc = resources.getStringArray(R.array.tour_description)
            val listTours = ArrayList<Tours>()
            for (i in tourName.indices) {
                val tour = Tours(tourName[i], tourDesc[i], tourPhoto.getResourceId(i, -1), latTour[i], longTour[i])
                listTours.add(tour)
            }
            return listTours
        }
}