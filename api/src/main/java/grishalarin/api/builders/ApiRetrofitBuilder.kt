package grishalarin.api.builders

import com.google.gson.GsonBuilder
import grishalarin.api.ApiConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class ApiRetrofitBuilder @Inject internal constructor(
    /**
     * Конфигурация API.
     */
    private val apiConfig: ApiConfig,
    /**
     * Билдер http-клиента
     */
    private val apiHttpClientBuilder: ApiHttpClientBuilder
) {

    /**
     * Создает клиент ретрофит
     */
    fun build(): Retrofit {
        val client = apiHttpClientBuilder.build()
        val gson = GsonBuilder().create()

        return Retrofit.Builder()
            .baseUrl(apiConfig.url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}