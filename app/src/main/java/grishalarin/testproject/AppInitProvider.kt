package grishalarin.testproject

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.net.Uri
import grishalarin.api.ApiComponent
import grishalarin.api.ApiConfig
import grishalarin.api.ApiModule
import grishalarin.api.DaggerApiComponentImpl
import grishalarin.api.appinfo.ApplicationInfo
import grishalarin.localdb.LocalDbModule
import grishalarin.testproject.helper.rx.RxErrorHandler
import io.reactivex.plugins.RxJavaPlugins

/**
 * @author Sostavkin Grisha
 */
class AppInitProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        initDI(context!!)
        AppComponent.get().inject(this)
        initRxPlugins()

        return false
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? = null

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun getType(uri: Uri): String? = null

    private fun initRxPlugins() {
        RxJavaPlugins.setErrorHandler(RxErrorHandler())
    }

    private fun initDI(appContext: Context) {
        val app = appContext as Application
        val apiConfig = ApiConfig(BuildConfig.API_BASE_URL)
        val applicationInfo = ApplicationInfo(
            BuildConfig.DEBUG,
            BuildConfig.APPLICATION_ID,
            BuildConfig.BUILD_TYPE,
            BuildConfig.FLAVOR,
            BuildConfig.VERSION_CODE,
            BuildConfig.VERSION_NAME
        )
        val apiComponent = DaggerApiComponentImpl
            .builder()
            .apiModule(ApiModule(apiConfig, applicationInfo))
            .build()
        ApiComponent.set(apiComponent)
        val apiModule = ApiModule(apiConfig, applicationInfo)
        val localDbModule = LocalDbModule(context!!)
        val appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(app))
            .apiModule(apiModule)
            .localDbModule(localDbModule)
            .build()
        AppComponent.set(appComponent)
        AppComponent.get().inject(this)
    }
}