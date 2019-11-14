package grishalarin.api

import grishalarin.api.apiworker.ApiWorker
import grishalarin.api.builders.ApiRetrofitBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * @author Sostavkin Grisha
 */
interface ApiComponent {
    /**
     * [OkHttpClient] для приложения
     */
    fun httpClient(): OkHttpClient
    /**
     * [Retrofit] для работы с API
     */
    fun apiRetrofit(): Retrofit

    /**
     * Билдер инстанса Retrofit для работы с API
     */
    fun apiRetrofitBuilder(): ApiRetrofitBuilder

    fun apiWorker(): ApiWorker

    companion object {
        private lateinit var instance: ApiComponent

        fun get(): ApiComponent = instance

        fun set(authComponent: ApiComponent) {
            instance = authComponent
        }
    }
}