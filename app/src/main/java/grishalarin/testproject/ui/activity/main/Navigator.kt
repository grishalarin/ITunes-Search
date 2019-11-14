package grishalarin.testproject.ui.activity.main

import grishalarin.testproject.dagger.ScreenScope
import grishalarin.testproject.ui.fragment.FragmentNavigator
import grishalarin.testproject.ui.fragment.main.album.AlbumFragment
import grishalarin.testproject.ui.fragment.main.albums.AlbumsFragment
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
@ScreenScope
class Navigator @Inject constructor(private val fragmentNavigator: FragmentNavigator) {

    fun navigateToAlbums(){
        val fragment = { AlbumsFragment.newInstance() }
        fragmentNavigator.newChain(fragment,Screen.ALBUMS)
    }

    fun navigateToAlbum(params: AlbumParams){
        val fragment = { AlbumFragment.newInstance(params)}
        fragmentNavigator.forward(fragment,Screen.ALBUM)
    }

    object Screen{
        const val ALBUMS = "ALBUMS"
        const val ALBUM = "ALBUM"
    }
}