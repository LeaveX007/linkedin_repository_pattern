import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import service.RemoteWeatherDataSource
import kotlin.test.Test
import kotlin.test.assertEquals

class RemoteWeatherDataSourceTest : KoinTest {

    @Test
    fun `test fetchData`() {
        startKoin {
            modules(
                module {
                    singleOf(::RemoteWeatherDataSource)
                }
            )
        }
        val localWeatherDataSource by inject<RemoteWeatherDataSource>()
        assertEquals(localWeatherDataSource.fetchData(), "Wetterdaten vom Server: Wolkig, 20°C")
    }

}