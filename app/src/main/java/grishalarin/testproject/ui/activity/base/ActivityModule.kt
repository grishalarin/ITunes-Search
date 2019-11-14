package grishalarin.testproject.ui.activity.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import grishalarin.testproject.dagger.ActivityScope

/**
 * @author Sostavkin Grisha
 */
@Module
class ActivityModule constructor(val activity: AppCompatActivity) {

    @ActivityScope
    @Provides
    internal fun activity(): Activity {
        return activity
    }

    @ActivityScope
    @Provides
    internal fun appCompatActivity(): AppCompatActivity {
        return activity
    }

}