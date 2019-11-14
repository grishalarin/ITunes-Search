package grishalarin.testproject.ui.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import grishalarin.testproject.R
import grishalarin.testproject.dagger.ScreenScope
import java.util.*
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
@ScreenScope
class FragmentNavigator @Inject constructor() {

    private var _activity: AppCompatActivity? = null
    private val activity
        get() = _activity!!
    private val fragmentManager
        get() = activity.supportFragmentManager
    private val containerId = R.id.activity_main_container
    private val buffer = LinkedList<() -> Unit>()
    private val isResumed
        get() = _activity != null
    var listener: Listener? = null
    private val screenStack = LinkedList<String>()

    fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState?.getBundle(SS_FRAGMENT_NAVIGATOR_BUNDLE)?.apply {
            val stackArray = getStringArray(SS_STACK)
            screenStack.clear()
            screenStack.addAll(stackArray!!)
        }
        navigateToEntryPoint()
    }

    fun onResume(activity: AppCompatActivity) {
        this._activity = activity
        while (buffer.isNotEmpty()) {
            buffer.pop()()
        }
    }

    fun onPause(activity: AppCompatActivity) {
        this._activity = null
    }

    fun onSaveInstanceState(outState: Bundle) {
        val bundle = Bundle()
        val stackArray = Array(screenStack.size) { screenStack[it] }
        bundle.putStringArray(SS_STACK, stackArray)
        outState.putBundle(SS_FRAGMENT_NAVIGATOR_BUNDLE, bundle)
    }

    private fun navigateToEntryPoint() {
        post {
            if (isEmpty()) {
                listener?.onNavigateToEntryPoint()
            }
        }
    }

    fun newChain(fragment: () -> Fragment, screenKey: String) {
        post {
            if (isCurrent(screenKey)) {
                return@post
            }
            backToRootInternal()
            forwardInternal(fragment, screenKey)
            onFragmentChanged()
        }
    }

    fun forward(fragment: () -> Fragment, screenKey: String) {
        post {
            if (isCurrent(screenKey)) {
                return@post
            }
            forwardInternal(fragment, screenKey)
            onFragmentChanged()
        }
    }

    private fun forwardInternal(fragment: () -> Fragment, screenKey: String) {
        fragmentManager
            .beginTransaction()
            .replace(containerId, fragment())
            .addToBackStack(screenKey)
            .commit()
        screenStack.push(screenKey)
        onFragmentChanged()
    }

    fun navigateBack() {
        post {
            val activeScreen = screenStack.pop()
            if (screenStack.isEmpty()) {
                listener?.onNavigateBackWithCleanStack(activeScreen)
            } else {
                fragmentManager.popBackStack()
                onFragmentChanged()
            }
        }
    }

    private fun backToRootInternal() {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        screenStack.clear()
    }

    private fun isCurrent(screenKey: String): Boolean {
        val count = fragmentManager.backStackEntryCount
        if (count > 0) {
            val entry = fragmentManager.getBackStackEntryAt(count - 1)
            if (entry.name == screenKey) {
                return true
            }
        }
        return false
    }

    private fun isEmpty(): Boolean {
        return fragmentManager.findFragmentById(containerId) == null
    }

    private fun post(func: () -> Unit) {
        if (isResumed) {
            func()
        } else {
            buffer.addLast(func)
        }
    }

    private fun onFragmentChanged() {
        val topScreen = screenStack.peek()
        listener?.onFragmentChanged(topScreen, screenStack.size)
    }

    interface Listener {
        fun onNavigateToEntryPoint()
        fun onNavigateBackWithCleanStack(topScreen: String)
        fun onFragmentChanged(topScreen: String, stackSize: Int)
    }

    companion object {
        const val SS_FRAGMENT_NAVIGATOR_BUNDLE = "SS_FRAGMENT_NAVIGATOR_BUNDLE"
        const val SS_STACK = "SS_STACK"
    }
}