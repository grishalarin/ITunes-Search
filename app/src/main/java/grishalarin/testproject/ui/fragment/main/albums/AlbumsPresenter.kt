package grishalarin.testproject.ui.fragment.main.albums

import grishalarin.localdb.model.Album
import grishalarin.testproject.helper.extension.filterByCollectionName
import grishalarin.testproject.mvp.presenter.BaseMvpViewStatePresenter
import grishalarin.testproject.ui.activity.main.Navigator
import grishalarin.testproject.ui.fragment.main.albums.interactor.AlbumsLoader
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import ru.digipeople.logger.LoggerFactory
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumsPresenter @Inject constructor(viewState: AlbumsViewState,
                                          private val albumsLoader: AlbumsLoader,
                                          private val navigator: Navigator)
    : BaseMvpViewStatePresenter<AlbumsView, AlbumsViewState>(viewState){

    private var disposableLoader: Disposable = Disposables.disposed()
    private val logger = LoggerFactory.getLogger(AlbumsPresenter::class)

    override fun onInitialize() {
        loadFromApi()
    }

    override fun destroy() {
        super.destroy()
        disposableLoader.dispose()
    }

    fun searchChanged(search: String) {
        applySearch(search)
    }

    fun searchSubmitted(search: String) {
        applySearch(search)
    }

    fun onSearchCloseButtonClicked(){
        disposableLoader.dispose()
        disposableLoader = albumsLoader.getAlbumsFromDb()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({albums ->
                view.setData(albums.filterByCollectionName())
            }){
                logger.error(it)
            }
    }

    fun onAlbumClicked(album: Album){
        val params = AlbumParams(album.id,album.artistId,album.wrapperType,album.collectionType,album.amgArtistId,album.artistName,
            album.collectionCensoredName,album.artistViewUrl,album.collectionViewUrl,album.artworkUrl60,album.artworkUrl100,album.collectionPrice,
            album.collectionExplicitness,album.trackCount,album.copyright,album.country,album.currency,album.releaseDate,album.primaryGenreName)
        navigator.navigateToAlbum(params)
    }

    fun swipeToRefresh() {
        loadFromDb()
        view.setLoading(false)
    }

    private fun loadFromApi() {
        disposableLoader.dispose()
        disposableLoader = albumsLoader.getAlbums("")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ albums ->
                view.setData(albums.filterByCollectionName())
            },{
                logger.error(it)
            })
    }

    private fun loadFromDb() {
        disposableLoader.dispose()
        disposableLoader = albumsLoader.getAlbumsFromDb()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({albums ->
                view.setData(albums.filterByCollectionName())
            },{
                logger.error(it)
            })
    }

    private fun applySearch(search: String) {
        disposableLoader.dispose()
        disposableLoader = albumsLoader.getAlbums(search)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ albums ->
                view.setData(albums.filterByCollectionName())
            },{
                logger.error(it)
            })
    }
}