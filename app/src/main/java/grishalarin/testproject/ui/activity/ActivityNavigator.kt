package grishalarin.testproject.ui.activity

import android.app.Activity
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class ActivityNavigator @Inject constructor() {

    fun navigateBack(activity: Activity) {
        activity.finish()
        animBack(activity)
    }

    private fun animForward(activity: Activity) {
        // TODO Реализовать
    }

    private fun animBack(activity: Activity) {
        // TODO Реализовать
    }
}