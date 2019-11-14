package grishalarin.api.builders

import grishalarin.api.ApiConfig
import grishalarin.api.appinfo.ApplicationInfo
import grishalarin.api.interceptor.AppInfoOkHttpInterceptor
import grishalarin.api.interceptor.AuthOkHttpInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class ApiHttpClientBuilder @Inject internal constructor(
    /**
     * Информация о приложении.
     */
    private val applicationInfo: ApplicationInfo,
    /**
     * Http-клиент.
     */
    private val baseOkHttpClient: OkHttpClient,
    private val apiConfig: ApiConfig

) {

    fun build(): OkHttpClient {

        return baseOkHttpClient.newBuilder()
            .addInterceptor(AppInfoOkHttpInterceptor(applicationInfo))
            .addInterceptor(AuthOkHttpInterceptor(apiConfig))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    companion object {
        /**
         * Таймаут на подключение/чтение/запись (в секундах)
         */
        private const val TIMEOUT: Long = 15
    }
}