package grishalarin.testproject.ui.activity.main

import dagger.Subcomponent
import grishalarin.testproject.dagger.ActivityScope
import grishalarin.testproject.ui.activity.base.ActivityModule
import grishalarin.testproject.ui.fragment.main.album.AlbumComponent
import grishalarin.testproject.ui.fragment.main.albums.AlbumsComponent

/**
 * @author Sostavkin Grisha
 */
@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
    fun mainPresenter(): MainPresenter
    fun albumsComponent(): AlbumsComponent
    fun albumComponent(): AlbumComponent
}