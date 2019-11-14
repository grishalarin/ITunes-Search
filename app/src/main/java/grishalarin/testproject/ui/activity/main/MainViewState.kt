package grishalarin.testproject.ui.activity.main

import grishalarin.testproject.mvp.viewstate.BaseMvpViewState
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class MainViewState @Inject constructor()
    : BaseMvpViewState<MainView>(), MainView {

    override fun onViewAttached(view: MainView) {}

    override fun onViewDetached(view: MainView) {}

    override fun onNavigateToEntryPoint() {
        forEachView { it.onNavigateToEntryPoint() }
    }
}