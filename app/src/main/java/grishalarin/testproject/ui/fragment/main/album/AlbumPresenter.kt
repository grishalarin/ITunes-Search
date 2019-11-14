package grishalarin.testproject.ui.fragment.main.album

import grishalarin.localdb.model.WrapperType
import grishalarin.testproject.mvp.presenter.BaseMvpViewStatePresenter
import grishalarin.testproject.ui.fragment.main.album.interactor.TrackLoader
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import ru.digipeople.logger.LoggerFactory
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumPresenter @Inject constructor(
    viewState: AlbumViewState,
    private val trackLoader: TrackLoader
) : BaseMvpViewStatePresenter<AlbumView, AlbumViewState>(viewState) {

    private var albumDisposable: Disposable = Disposables.disposed()
    private val logger = LoggerFactory.getLogger(AlbumPresenter::class)


    override fun onInitialize() {}

    fun loadAlbum(albumId: Int) {
        albumDisposable = trackLoader.getAlbums(albumId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tracks ->
                val filteredList = tracks.filter { it.wrapperType == WrapperType.TRACK }
                val sortedList = filteredList.sortedWith(compareBy { it.trackNumber })
                view.setDataToAdapter(sortedList)
            }, {
                logger.error(it)
            })
    }

    fun setDataToAlbum(albumParams: AlbumParams) {
        view.setDataToViews(albumParams)
    }

    fun convertDate(date: Date): String {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(date)
    }

    companion object {
        private const val DATE_FORMAT = "dd.MM.yyyy"
    }
}