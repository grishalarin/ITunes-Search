package grishalarin.testproject.ui.activity.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import grishalarin.testproject.AppComponent
import grishalarin.testproject.mvp.MvpDelegate
import grishalarin.testproject.mvp.view.MvpView

/**
 * @author Sostavkin Grisha
 */
open class MvpActivity : AppCompatActivity() {
    /**
     * Делегат для хранения/получения тега
     */
    private var mvpDelegate: MvpDelegate? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mvpDelegate = MvpDelegate(
            AppComponent.get().mvpProcessor(),
            this as MvpView
        )
        mvpDelegate!!.init(savedInstanceState)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    fun getMvpDelegate(): MvpDelegate {
        return mvpDelegate!!
    }

    override fun onStart() {
        super.onStart()
        mvpDelegate!!.bindView()
    }

    override fun onStop() {
        mvpDelegate!!.unbindView()
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mvpDelegate!!.saveState(outState)
    }

    override fun onDestroy() {
        mvpDelegate!!.destroy(keepAlive())
        super.onDestroy()
    }

    private fun keepAlive(): Boolean {
        return !isFinishing
    }
}