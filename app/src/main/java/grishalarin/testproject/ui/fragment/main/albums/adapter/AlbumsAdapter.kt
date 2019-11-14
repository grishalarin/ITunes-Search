package grishalarin.testproject.ui.fragment.main.albums.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import grishalarin.localdb.model.Album
import grishalarin.testproject.R
import grishalarin.testproject.helper.extension.autoNotify
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @author Sostavkin Grisha
 */
class AlbumsAdapter @Inject constructor() : RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {
    //region Other
    var itemListener: ((album: Album) -> Unit)? = null
    var items: List<Album> by Delegates.observable(emptyList()) { prop, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.id == n.id }
    }
    //endRegion

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_album, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val image = view.findViewById<ImageView>(R.id.item_album_image)
        private val albumName = view.findViewById<TextView>(R.id.item_album_name)
        private val artistName = view.findViewById<TextView>(R.id.item_album_artist_name)

        fun bind(album: Album) {
            albumName.text = album.collectionCensoredName
            Picasso.get().load(album.artworkUrl100).placeholder(R.drawable.placeholder).fit().into(image)
            artistName.text = album.artistName
            itemView.setOnClickListener { itemListener?.invoke(album) }
        }
    }
}

