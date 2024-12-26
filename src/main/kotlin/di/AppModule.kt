package di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import repository.WeatherRepository
import service.LocalWeatherDataSource
import service.RemoteWeatherDataSource

val appModule = module {
    singleOf(::LocalWeatherDataSource)
    singleOf(::RemoteWeatherDataSource)
    single { WeatherRepository(get(), get()) }
}