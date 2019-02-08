package elnaggar.madarsofttask.pojo

data class Weather(
    var base: String? = "",
    var clouds: Clouds? = Clouds(),
    var cod: Int? = 0,
    var coord: Coord? = Coord(),
    var dt: Int? = 0,
    var id: Int? = 0,
    var main: Main? = Main(),
    var name: String? = "",
    var sys: Sys? = Sys(),
    var weather: List<WeatherX?>? = listOf(),
    var wind: Wind? = Wind()
)