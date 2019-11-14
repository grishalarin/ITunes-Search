package grishalarin.api.interceptor

import grishalarin.api.appinfo.ApplicationInfo
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * @author Sostavkin Grisha
 */
class AppInfoOkHttpInterceptor(applicationInfo: ApplicationInfo) : Interceptor {

    private val appInfo: String

    init {
        val sb = StringBuilder()
        sb.append("AppVersionName: ").append(applicationInfo.versionName).append(", ")
        sb.append("AppVersionCode: ").append(applicationInfo.versionCode).append(", ")
        // Пока flavor-ов нет
        //sb.append("Flavor: ").append(applicationInfo.getFlavor()).append(", ");
        sb.append("BuildType: ").append(applicationInfo.buildType).append(" ")
        appInfo = sb.toString()
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Application-Info", appInfo)
            .build()
        return chain.proceed(request)
    }
}