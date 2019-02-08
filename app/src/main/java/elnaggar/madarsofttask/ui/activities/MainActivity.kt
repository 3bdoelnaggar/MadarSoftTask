package elnaggar.madarsofttask.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import elnaggar.madarsofttask.R
import elnaggar.madarsofttask.database.LocationDatabase
import elnaggar.madarsofttask.pojo.Location
import elnaggar.madarsofttask.pojo.Weather
import elnaggar.madarsofttask.presenters.MainActivityPresenter
import elnaggar.madarsofttask.ui.adapters.LocationWeatherAdapter
import kotlinx.android.synthetic.main.activity_main.*

const val ADD_NEW_LOCATION_REQUEST_CODE = 1


class MainActivity : AppCompatActivity() {

    private val items= ArrayList<Weather>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_locationWeatherList.adapter = LocationWeatherAdapter(items)
        btn_add.setOnClickListener {
            startActivityForResult(Intent(this, MapsActivity::class.java), ADD_NEW_LOCATION_REQUEST_CODE)
        }


    }

    override fun onResume() {
        super.onResume()
        val locations = LocationDatabase.getInstance(this).locationDao().readAll()
        if(locations!=null&& locations.isNotEmpty()){
            val activityPresenter = MainActivityPresenter()
            locations.forEach {
                activityPresenter.getWeatherData(it.latitude, it.longitude,::onSuccess,::onError)

            }

        }

    }

    private fun onError(throwable: Throwable) {
        Toast.makeText(this,throwable.message,Toast.LENGTH_SHORT).show()


    }

    private fun onSuccess(weather: Weather){
        items.add(weather)
        recyclerView_locationWeatherList.adapter?.notifyDataSetChanged()


    }



}
