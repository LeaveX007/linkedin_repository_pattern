package repository

import service.LocalWeatherDataSource
import service.RemoteWeatherDataSource

class WeatherRepository(
    private val localWeatherDataSource: LocalWeatherDataSource,
    private val remoteWeatherDataSource: RemoteWeatherDataSource
) {
    fun getData(fromCache: Boolean = false): String {
        return if (fromCache) {
            localWeatherDataSource.fetchData()
        } else {
            remoteWeatherDataSource.fetchData()
        }
    }
}