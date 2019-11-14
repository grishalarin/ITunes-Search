package grishalarin.testproject.ui.fragment.main.album.mapper

import grishalarin.api.model.TracksResponse
import grishalarin.localdb.model.Track
import grishalarin.localdb.model.WrapperType
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class TrackMapper @Inject constructor() {

    fun resultsToTracks(tracksResponse: List<TracksResponse.TrackResponse>): List<Track> {
        val items = mutableListOf<Track>()
        tracksResponse.forEach { trackResponse ->
            items.add(trackResponseToTrack(trackResponse))
        }
        return items
    }

    private fun trackResponseToTrack(result: TracksResponse.TrackResponse): Track {
        val item = Track()
        item.collectionId = result.collectionId
        item.wrapperType = convertWrapperType(result.wrapperType)
        item.kind = result.kind
        item.artistId = result.artistId
        item.trackId = result.trackId
        item.artistName = result.artistName
        item.collectionName = result.collectionName
        item.trackName = result.trackName
        item.trackCensoreName = result.trackCensoreName
        item.artistViewUrl = result.artistViewUrl
        item.collectionViewUrl = result.collectionViewUrl
        item.trackViewUrl = result.trackViewUrl
        item.previewUrl = result.previewUrl
        item.artworkUrl30 = result.artworkUrl30
        item.artworkUrl60 = result.artworkUrl60
        item.artworkUrl100 = result.artworkUrl100
        item.collectionPrice = result.collectionPrice
        item.trackPrice = result.trackPrice
        item.releaseDate = convertStringToDate(result.releaseDate)
        item.trackTime = convertMillisecondsToMinutes(result.trackTime)
        item.collectionExplicitness = result.collectionExplicitness
        item.trackExplicitness = result.trackExplicitness
        item.discCount = result.discCount
        item.discNumber = result.discNumber
        item.trackNumber = result.trackNumber
        item.trackCount = result.trackCount
        item.country = result.country
        item.currency = result.currency
        item.primaryGenreName = result.primaryGenreName
        item.isStreamable = result.isStreamable
        return item
    }

    private fun convertMillisecondsToMinutes(milliseconds: Long): Date {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliseconds
        return calendar.time
    }

    private fun convertStringToDate(date: String): Date {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(date)!!
    }

    private fun convertWrapperType(type: String): WrapperType {
        return when (type) {
            WrapperType.COLLECTION.type -> WrapperType.COLLECTION
            WrapperType.TRACK.type -> WrapperType.TRACK
            else -> WrapperType.UNKNOWN
        }
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    }
}
