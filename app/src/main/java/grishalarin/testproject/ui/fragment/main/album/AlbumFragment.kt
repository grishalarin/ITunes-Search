package grishalarin.testproject.ui.fragment.main.album

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import grishalarin.localdb.model.Track
import grishalarin.testproject.R
import grishalarin.testproject.ui.activity.main.MainActivity
import grishalarin.testproject.ui.fragment.base.MvpFragment
import grishalarin.testproject.ui.fragment.main.album.adapter.TrackAdapter
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumFragment : MvpFragment(), AlbumView {

    //region DI
    private lateinit var component: AlbumComponent
    @Inject
    lateinit var adapter: TrackAdapter
    //endRegion
    //region View
    private lateinit var recycler: RecyclerView
    private lateinit var image: ImageView
    private lateinit var artistName: TextView
    private lateinit var albumName: TextView
    private lateinit var trackCount: TextView
    private lateinit var releaseDate: TextView
    private lateinit var genre: TextView
    private lateinit var price: TextView
    //endRegion
    // region Other
    private lateinit var presenter: AlbumPresenter
    //endRegion

    override fun onCreate(savedInstanceState: Bundle?) {
        component = (activity as MainActivity).component().albumComponent()
        component.inject(this)
        super.onCreate(savedInstanceState)

        presenter = mvpDelegate.getPresenter({ component.presenter() }, AlbumPresenter::class.java)
        presenter.initialize()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_album, container, false)

        initViews(view)

        val albumParams = arguments?.getParcelable<AlbumParams>(EXTRA_ALBUM)
        presenter.setDataToAlbum(albumParams!!)
        presenter.loadAlbum(albumParams.id.toInt())

        return view
    }

    private fun initViews(view: View){
        image = view.findViewById(R.id.album_image)
        artistName = view.findViewById(R.id.fragment_album_artist_name)
        albumName = view.findViewById(R.id.fragment_album_collection_censore_name)
        trackCount = view.findViewById(R.id.fragment_album_track_count)
        releaseDate = view.findViewById(R.id.fragment_album_release_date)
        genre = view.findViewById(R.id.fragment_album_genre)
        price = view.findViewById(R.id.fragment_album_collection_price)
        recycler = view.findViewById(R.id.fragment_album_recycler)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = adapter

        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                linearLayoutManager.orientation
            )
        )
    }

    override fun setDataToViews(album: AlbumParams) {
        Picasso.get().load(album.artworkUrl100).resize(IMAGE_WIDTH,IMAGE_HEIGHT).into(image)
        artistName.text = album.artistName
        albumName.text = album.collectionCensoredName
        trackCount.text = getString(R.string.album_fragment_track_count,album.trackCount)
        releaseDate.text = getString(R.string.album_fragment_release_date, presenter.convertDate(album.releaseDate))
        genre.text = getString(R.string.album_fragment_genre, album.primaryGenreName)
        price.text = getString(R.string.album_fragment_price,album.collectionPrice, album.currency)
    }

    override fun setDataToAdapter(tracks: List<Track>) {
        adapter.items = tracks
    }

    companion object {

        private const val EXTRA_ALBUM = "EXTRA_ALBUM"
        private const val IMAGE_HEIGHT = 200
        private const val IMAGE_WIDTH = 200

        fun newInstance(params: AlbumParams) = AlbumFragment().apply {
            arguments = Bundle().apply {
                putParcelable(EXTRA_ALBUM, params)
            }
        }
    }
}