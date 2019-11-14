package grishalarin.testproject.ui.fragment.main.albums

import dagger.Subcomponent
import grishalarin.testproject.dagger.FragmentScope

/**
 * @author Sostavkin Grisha
 */
@FragmentScope
@Subcomponent
interface AlbumsComponent {
    fun inject(fragment: AlbumsFragment)
    fun presenter(): AlbumsPresenter
}