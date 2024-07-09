package com.example.kotabandung


import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.kotabandung.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        getMyLocation()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        val rancaUpas = LatLng(-7.141133, 107.395703)
        mMap.addMarker(MarkerOptions().position(rancaUpas).title("Kampung Cai Ranca Upas"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rancaUpas, 9f))

        val kawahPutih = LatLng(-7.166018, 107.403275)
        mMap.addMarker(MarkerOptions().position(kawahPutih).title("Kawah Putih Ciwidey"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kawahPutih, 9f))

        val lembangParkZoo = LatLng(-6.805889, 107.591978)
        mMap.addMarker(MarkerOptions().position(lembangParkZoo).title("Lembang Park & Zoo"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lembangParkZoo, 9f))

        val greatAsia = LatLng(-6.832904, 107.604095)
        mMap.addMarker(MarkerOptions().position(greatAsia).title("The Great Asia Africa"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(greatAsia, 9f))

        val orchidForest = LatLng(-6.780420, 107.637500)
        mMap.addMarker(MarkerOptions().position(orchidForest).title("Orchid Forest Cikole"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(orchidForest, 9f))

        val paskalFoodMarker = LatLng(-6.914456825044003, 107.59234625730564)
        mMap.addMarker(MarkerOptions().position(paskalFoodMarker).title("Paskal Food Market"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(paskalFoodMarker, 9f))

        val sudirmanStreetBandung = LatLng(-6.9206596552926065, 107.60059244049333)
        mMap.addMarker(MarkerOptions().position(sudirmanStreetBandung).title("Sudirman Street Bandung"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sudirmanStreetBandung, 9f))

        val mieRicaKejaksaan = LatLng(-6.918418493687307, 107.61018923659923)
        mMap.addMarker(MarkerOptions().position(mieRicaKejaksaan).title("Mie Rica Kejaksaan"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mieRicaKejaksaan, 9f))

        val mihKocokBandungMangDadeng = LatLng(-6.9343600166905865, 107.6242793084884)
        mMap.addMarker(MarkerOptions().position(mihKocokBandungMangDadeng).title("Mih Kocok Bandung Mang Dadeng"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mihKocokBandungMangDadeng, 9f))

        val sateJandoGasibu = LatLng(-6.903868650292857, 107.61800447550907)
        mMap.addMarker(MarkerOptions().position(sateJandoGasibu).title("Sate Jando Gasibu"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sateJandoGasibu, 9f))

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

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getMyLocation()
            }
        }

    private fun getMyLocation() {
        if (ContextCompat.checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

}