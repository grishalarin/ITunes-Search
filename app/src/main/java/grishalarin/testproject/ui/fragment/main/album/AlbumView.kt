package grishalarin.testproject.ui.fragment.main.album

import grishalarin.localdb.model.Track
import grishalarin.testproject.mvp.view.MvpView
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams

/**
 * @author Sostavkin Grisha
 */
interface AlbumView : MvpView {
    fun setDataToViews(album: AlbumParams)
    fun setDataToAdapter(tracks: List<Track>)
}