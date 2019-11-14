package grishalarin.testproject.ui.fragment.main.album

import dagger.Subcomponent
import grishalarin.testproject.dagger.FragmentScope

/**
 * @author Sostavkin Grisha
 */
@FragmentScope
@Subcomponent
interface AlbumComponent {
    fun inject(fragment: AlbumFragment)
    fun presenter(): AlbumPresenter
}