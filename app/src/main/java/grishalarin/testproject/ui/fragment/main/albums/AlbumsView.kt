package grishalarin.testproject.ui.fragment.main.albums

import grishalarin.localdb.model.Album
import grishalarin.testproject.mvp.view.MvpView

/**
 * @author Sostavkin Grisha
 */
interface AlbumsView : MvpView {
    fun setLoading(loading: Boolean)
    fun setData(items: List<Album>)
}