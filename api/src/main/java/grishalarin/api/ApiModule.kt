package grishalarin.api

import dagger.Module
import dagger.Provides
import grishalarin.api.apiworker.ApiWorker
import grishalarin.api.apiworker.DefaultApiWorker
import grishalarin.api.appinfo.ApplicationInfo
import grishalarin.api.builders.ApiRetrofitBuilder
import grishalarin.api.response.ResponseConverter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Module
class ApiModule(private val apiConfig: ApiConfig,
                private val applicationInfo: ApplicationInfo
) {

    @Provides
    internal fun apiConfig() = apiConfig

    @Provides
    internal fun applicationInfo() = applicationInfo

    @Provides
    @Singleton
    internal fun httpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    internal fun apiWorker(retrofit: Retrofit,
                           responseConverter: ResponseConverter
    ): ApiWorker {
        val api = retrofit.create(Api::class.java)
        return DefaultApiWorker(api, responseConverter)
    }

    @Provides
    @Singleton
    fun retrofit(apiRetrofitBuilder: ApiRetrofitBuilder): Retrofit{
        return  apiRetrofitBuilder.build()
    }

    @Provides
    @Singleton
    internal fun responseConverter(retrofit: Retrofit): ResponseConverter {
        return ResponseConverter(retrofit)
    }
}