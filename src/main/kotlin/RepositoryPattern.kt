import di.appModule
import org.koin.core.context.startKoin
import org.koin.mp.KoinPlatform.getKoin
import repository.WeatherRepository

fun main() {
    startKoin {
        modules(appModule)
    }

    val weatherRepository: WeatherRepository = getKoin().get<WeatherRepository>()

    println(weatherRepository.getData(fromCache = true))
    println(weatherRepository.getData())
}