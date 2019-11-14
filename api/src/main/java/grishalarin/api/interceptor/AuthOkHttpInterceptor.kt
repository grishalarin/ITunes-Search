package grishalarin.api.interceptor

import grishalarin.api.ApiConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * @author Sostavkin Grisha
 */
class AuthOkHttpInterceptor(private val apiConfig: ApiConfig) : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url()
            .newBuilder()
            .build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}