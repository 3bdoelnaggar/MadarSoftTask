package elnaggar.madarsofttask.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import elnaggar.madarsofttask.R
import elnaggar.madarsofttask.pojo.Weather
import kotlinx.android.synthetic.main.location_weather_list_item.view.*

class LocationWeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bindTo(weather: Weather) {
        itemView.tv_locationName.text = weather.name
        itemView.tv_temp.text = weather.main?.temp.toString()+"\u00b0"+"F"
        itemView.tv_windSpeed.text=weather.wind?.speed?.toString()+"meter/sec"
    }

    companion object {
        fun create(parent: ViewGroup): LocationWeatherViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.location_weather_list_item, parent, false)
            return LocationWeatherViewHolder(view)

        }
    }


}
