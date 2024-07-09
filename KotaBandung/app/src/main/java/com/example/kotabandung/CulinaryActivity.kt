package com.example.kotabandung

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CulinaryActivity : AppCompatActivity() {

    private lateinit var rv_culinarys: RecyclerView
    private val list = ArrayList<Culinary>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_culinary)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rv_culinarys = findViewById(R.id.rv_culinarys)
        rv_culinarys.setHasFixedSize(true)

        list.addAll(listCulinarys)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rv_culinarys.layoutManager = GridLayoutManager(this, 2)
        } else {
            rv_culinarys.layoutManager = LinearLayoutManager(this)
        }
        val listCulinaryAdapter = ListCulinaryAdapter(list)
        rv_culinarys.adapter = listCulinaryAdapter
    }

    private val latCulinary = doubleArrayOf(-6.914456825044003, -6.9206596552926065, -6.918418493687307, -6.9343600166905865, -6.903868650292857)
    private val longCulinary = doubleArrayOf(107.59234625730564, 107.60059244049333, 107.61018923659923, 107.6242793084884, 107.61800447550907)

    private val listCulinarys: ArrayList<Culinary>
        get() {
            val culinaryName = resources.getStringArray(R.array.culinary_name)
            val culinaryPhoto = resources.obtainTypedArray(R.array.photo_culinary)
            val culinaryDesc = resources.getStringArray(R.array.culinary_description)
            val listCulinarys = ArrayList<Culinary>()
            for (i in culinaryName.indices) {
                val culinary = Culinary(culinaryName[i], culinaryDesc[i], culinaryPhoto.getResourceId(i, -1), latCulinary[i], longCulinary[i])
                listCulinarys.add(culinary)
            }
            return listCulinarys
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