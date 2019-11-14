package grishalarin.testproject

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return app
    }
}