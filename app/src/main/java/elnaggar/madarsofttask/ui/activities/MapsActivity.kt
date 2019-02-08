package elnaggar.madarsofttask.ui.activities

import android.app.Activity
import android.content.Intent
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.view.View
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import elnaggar.madarsofttask.R
import elnaggar.madarsofttask.database.LocationDatabase
import elnaggar.madarsofttask.pojo.Location
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_maps.*
import java.util.*

const val LOCATION_RESULT = "location.result"

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



    }


    private var marker: Marker? = null

    private var chosenLocation: Location? = null

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapClickListener {
//            if (marker != null) {
//                marker?.remove()
//                marker = null
//            }
            val addressFromLatLong = getAddressFromLatLong(it)
            mMap.addMarker(MarkerOptions().position(it).title(addressFromLatLong))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(it))
            chosenLocation = Location(address = addressFromLatLong, latitude = it.latitude, longitude = it.longitude)
            chosenLocation?.let {
            LocationDatabase.getInstance(this).locationDao().insert(it)
            val locationAddedNum = LocationDatabase.getInstance(this).locationDao().readAll().size
                tv_locationsNum.visibility= View.VISIBLE
            tv_locationsNum.text = "you have $locationAddedNum Locations Saved";
            }


        }

    }

    private fun getAddressFromLatLong(it: LatLng): String {
        val geocoder = Geocoder(this, Locale("ar"))
        val addresses = geocoder.getFromLocation(it.latitude, it.longitude, 1)
        if (addresses != null && addresses.size > 0) {
            return addresses[0].getAddressLine(0)
        }
        return ""

    }
}
