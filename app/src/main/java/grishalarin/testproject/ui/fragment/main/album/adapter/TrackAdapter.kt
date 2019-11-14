package grishalarin.testproject.ui.fragment.main.album.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import grishalarin.localdb.model.Track
import grishalarin.testproject.R
import grishalarin.testproject.helper.extension.autoNotify
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * @author Sostavkin Grisha
 */
class TrackAdapter @Inject constructor() : RecyclerView.Adapter<TrackAdapter.ViewHolder>() {
    //region Other
    var itemListener: ((track: Track) -> Unit)? = null
    var items: List<Track> by Delegates.observable(emptyList()) { prop, oldList, newList ->
        autoNotify(oldList, newList) { o, n -> o.trackId == n.trackId }
    }
    //endRegion

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_track, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val number = view.findViewById<TextView>(R.id.item_track_number)
        private val name = view.findViewById<TextView>(R.id.item_track_name)

        fun bind(track: Track) {
            number.text = itemView.context.getString(R.string.item_track_number, track.trackNumber)
            name.text = track.trackName
            itemView.setOnClickListener { itemListener?.invoke(track) }
        }
    }
}