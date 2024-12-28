import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.junit5.KoinTestExtension
import org.koin.test.junit5.mock.MockProviderExtension
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.kotlin.verify
import repository.WeatherRepository
import service.LocalWeatherDataSource
import service.RemoteWeatherDataSource
import kotlin.test.Test

class WeatherRepositoryTest : KoinTest {

    val weatherRepositoryTest by inject<WeatherRepository>()

    @JvmField
    @RegisterExtension
    val koinTestExtension = KoinTestExtension.create {
        modules(
            module {
                singleOf(::LocalWeatherDataSource)
                singleOf(::RemoteWeatherDataSource)
                single { WeatherRepository(get(), get()) }
            }
        )
    }

    @JvmField
    @RegisterExtension
    val mockProvider = MockProviderExtension.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Test
    fun `Test if cache data source is called with parameter`() {
        val localWeatherDataSource = declareMock<LocalWeatherDataSource>()
        weatherRepositoryTest.getData(true)
        verify(localWeatherDataSource).fetchData()
    }

    @Test
    fun `Test if remote data source is called without parameter`() {
        val remoteWeatherDataSource = declareMock<RemoteWeatherDataSource>()
        weatherRepositoryTest.getData()
        verify(remoteWeatherDataSource).fetchData()
    }

    @Test
    fun `Test if remote data source is called with parameter`() {
        val localWeatherDataSource = declareMock<RemoteWeatherDataSource>()
        weatherRepositoryTest.getData(false)
        verify(localWeatherDataSource).fetchData()
    }

}