package grishalarin.testproject.ui.activity.main

import dagger.Subcomponent
import grishalarin.testproject.dagger.ScreenScope
import grishalarin.testproject.ui.activity.base.ActivityModule

/**
 * @author Sostavkin Grisha
 */
@ScreenScope
@Subcomponent
interface MainScreenComponent {
    fun mainComponent(activityModule: ActivityModule): MainComponent
}