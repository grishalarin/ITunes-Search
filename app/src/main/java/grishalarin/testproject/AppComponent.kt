package grishalarin.testproject

import android.content.Context
import dagger.Component
import grishalarin.api.ApiModule
import grishalarin.localdb.LocalDbModule
import grishalarin.testproject.ui.activity.main.MainScreenComponent
import grishalarin.testproject.mvp.core.MvpProcessor
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
@Component(modules = [AppModule::class, ApiModule::class, LocalDbModule::class])
interface AppComponent {
    fun inject(appInitProvider: AppInitProvider)

    fun context(): Context

    fun mvpProcessor(): MvpProcessor

    fun mainScreenComponent(): MainScreenComponent

    companion object {
        private lateinit var instance: AppComponent

        fun get(): AppComponent = instance

        fun set(appComponent: AppComponent) {
            instance = appComponent
        }
    }
}