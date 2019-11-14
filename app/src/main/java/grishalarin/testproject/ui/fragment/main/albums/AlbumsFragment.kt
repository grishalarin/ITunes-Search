package grishalarin.testproject.ui.fragment.main.albums

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import grishalarin.localdb.model.Album
import grishalarin.testproject.R
import grishalarin.testproject.ui.activity.main.MainActivity
import grishalarin.testproject.ui.fragment.base.MvpFragment
import grishalarin.testproject.ui.fragment.main.albums.adapter.AlbumsAdapter
import grishalarin.testproject.ui.fragment.main.albums.params.AlbumParams
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumsFragment : MvpFragment(), AlbumsView {

    //region DI
    private lateinit var component: AlbumsComponent
    @Inject
    lateinit var adapter: AlbumsAdapter
    //endRegion
    //region View
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recycler: RecyclerView
    //endRegion
    // region Other
    private lateinit var presenter: AlbumsPresenter
    //endRegion

    override fun onCreate(savedInstanceState: Bundle?) {
        component = (activity as MainActivity).component().albumsComponent()
        component.inject(this)
        super.onCreate(savedInstanceState)

        presenter = mvpDelegate.getPresenter({ component.presenter() }, AlbumsPresenter::class.java)
        presenter.initialize()

        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_albums, container, false)

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh)
        recycler = view.findViewById(R.id.fragment_album_list_recycler)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = adapter

        recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                linearLayoutManager.orientation
            )
        )

        swipeRefreshLayout.setOnRefreshListener {
            presenter.swipeToRefresh()
        }

        adapter.itemListener = presenter::onAlbumClicked
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)

        val searchManager = activity!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchMenuItem = menu.findItem(R.id.search)
        val searchView = searchMenuItem?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
        searchView.isSubmitButtonEnabled = false
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                presenter.searchSubmitted(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.searchChanged(newText!!)
                return true
            }
        })

        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                presenter.onSearchCloseButtonClicked()
            }
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun setData(items: List<Album>) {
        adapter.items = items
    }


    override fun setLoading(loading: Boolean) {
        swipeRefreshLayout.isRefreshing = loading
    }

    fun component(): AlbumsComponent {
        return component
    }

    companion object {
        fun newInstance() = AlbumsFragment()
    }
}