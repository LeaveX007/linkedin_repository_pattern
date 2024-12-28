import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import service.LocalWeatherDataSource
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalWeatherDataSourceTest : KoinTest {

    @Test
    fun `test fetchData`() {
        startKoin {
            modules(
                module {
                    singleOf(::LocalWeatherDataSource)
                }
            )
        }
        val localWeatherDataSource by inject<LocalWeatherDataSource>()
        assertEquals(localWeatherDataSource.fetchData(), "Wetterdaten vom Cache: Sonnig, 35°C")
    }

}