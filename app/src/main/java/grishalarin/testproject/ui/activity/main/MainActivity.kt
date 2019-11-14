package grishalarin.testproject.ui.activity.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import grishalarin.testproject.AppComponent
import grishalarin.testproject.R
import grishalarin.testproject.ui.activity.base.ActivityModule
import grishalarin.testproject.ui.activity.base.MvpActivity
import grishalarin.testproject.ui.fragment.FragmentNavigator
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class MainActivity : MvpActivity(), MainView {

    // region DI
    private lateinit var screenComponent: MainScreenComponent
    private lateinit var component: MainComponent
    @Inject
    lateinit var navigator: Navigator
    @Inject
    lateinit var fragmentNavigator: FragmentNavigator
    // region View
    // end region
    // region Other
    private lateinit var presenter: MainPresenter
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        screenComponent = getScreenComponent()
        component = screenComponent.mainComponent(ActivityModule(this))
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        presenter = getMvpDelegate().getPresenter({ component.mainPresenter() }, MainPresenter::class.java)
        presenter.initialize()
    }

    override fun onStart() {
        super.onStart()
        presenter.onScreenShow()
    }

    override fun onResume() {
        super.onResume()
        fragmentNavigator.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        fragmentNavigator.onPause(this)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState!!, outPersistentState!!)
        fragmentNavigator.onSaveInstanceState(outState)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return screenComponent
    }

    override fun onNavigateToEntryPoint() {
        navigator.navigateToAlbums()
    }

    fun component() = component

    private fun getScreenComponent(): MainScreenComponent {
        val saved = lastCustomNonConfigurationInstance
        return if (saved == null) AppComponent.get().mainScreenComponent() else saved as MainScreenComponent
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }
}