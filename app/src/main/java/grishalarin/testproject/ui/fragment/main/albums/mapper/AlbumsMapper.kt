package grishalarin.testproject.ui.fragment.main.albums.mapper

import grishalarin.api.model.AlbumsResponse
import grishalarin.localdb.model.Album
import grishalarin.testproject.ui.fragment.main.album.AlbumPresenter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumsMapper @Inject constructor() {

    fun resultsToAlbums(albumsModelsResponse: List<AlbumsResponse.AlbumModelResponse>): List<Album> {
        val items = mutableListOf<Album>()
        albumsModelsResponse.forEach { albumResponse ->
            items.add(albumResponseToAlbum(albumResponse))
        }
        return items
    }

    private fun albumResponseToAlbum(result: AlbumsResponse.AlbumModelResponse): Album {
        val item = Album()
        item.id = result.id.toLong()
        item.wrapperType = result.wrapperType
        item.collectionType = result.collectionType
        item.artistId = result.artistId
        item.amgArtistId = result.amgArtistId
        item.artistName = result.artistName
        item.collectionCensoredName = result.collectionCensoredName
        item.artistViewUrl = result.artistViewUrl
        item.collectionViewUrl = result.collectionViewUrl
        item.artworkUrl60 = result.artworkUrl60
        item.artworkUrl100 = result.artworkUrl100
        item.collectionPrice = result.collectionPrice
        item.collectionExplicitness = result.collectionExplicitness
        item.trackCount = result.trackCount
        item.copyright = result.copyright
        item.country = result.country
        item.currency = result.currency
        item.releaseDate = convertStringToDate(result.releaseDate)
        item.primaryGenreName = result.primaryGenreName
        return item
    }

    private fun convertStringToDate(date: String): Date{
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(date)!!
    }

    companion object{
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    }

}