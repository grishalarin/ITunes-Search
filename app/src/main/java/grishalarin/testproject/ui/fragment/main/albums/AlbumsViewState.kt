package grishalarin.testproject.ui.fragment.main.albums

import grishalarin.localdb.model.Album
import grishalarin.testproject.mvp.viewstate.BaseMvpViewState
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumsViewState @Inject constructor() : BaseMvpViewState<AlbumsView>(), AlbumsView {

    override fun onViewAttached(view: AlbumsView?) {}

    override fun onViewDetached(view: AlbumsView?) {}

    override fun setLoading(loading: Boolean) {
        forEachView { it.setLoading(loading) }
    }

    override fun setData(items: List<Album>) {
        forEachView { it.setData(items) }
    }
}