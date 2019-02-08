package elnaggar.madarsofttask.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import elnaggar.madarsofttask.pojo.Weather

class LocationWeatherAdapter(private val items: ArrayList<Weather>) :
    RecyclerView.Adapter<LocationWeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationWeatherViewHolder {
        return LocationWeatherViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LocationWeatherViewHolder, position: Int) {
        holder.bindTo(items[position])
    }

}
