package grishalarin.testproject.ui.activity.main

import grishalarin.testproject.mvp.presenter.BaseMvpViewStatePresenter
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class MainPresenter @Inject constructor(viewState: MainViewState) :
    BaseMvpViewStatePresenter<MainView, MainViewState>(viewState) {

    override fun onInitialize() {}

    fun onScreenShow(){
        view.onNavigateToEntryPoint()
    }
}