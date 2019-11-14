package grishalarin.testproject.ui.fragment.main.album

import grishalarin.localdb.model.Track
import grishalarin.testproject.mvp.viewstate.BaseMvpViewState
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumViewState @Inject constructor() : BaseMvpViewState<AlbumView>(), AlbumView {

    private var albumParams: AlbumParams? = null

    override fun onViewAttached(view: AlbumView?) {
        if (albumParams != null) {
            setDataToViews(albumParams!!)
        }
    }

    override fun onViewDetached(view: AlbumView?) {}

    override fun setDataToViews(album: AlbumParams) {
        albumParams = album
        forEachView { it.setDataToViews(album) }
    }

    override fun setDataToAdapter(tracks: List<Track>) {
        forEachView { it.setDataToAdapter(tracks) }
    }
}