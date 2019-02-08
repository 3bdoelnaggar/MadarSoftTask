package elnaggar.madarsofttask.presenters

import elnaggar.madarsofttask.BuildConfig
import elnaggar.madarsofttask.network.WeatherService
import elnaggar.madarsofttask.pojo.Weather
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter {

    public fun getWeatherData(
        lat: Double,
        long: Double,
        onSuccess: (Weather) -> Unit, onError: (Throwable) -> Unit
    ) {
        val observable = WeatherService.create().getWeather(BuildConfig.WEATHER_API_KEY, lat, long)
        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(onSuccess, onError)

    }





}
