package grishalarin.testproject.ui.fragment.main.albums.params

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * @author Sostavkin Grisha
 */
class AlbumParams(
    var id: Long,
    var artistId: Int,
    var wrapperType: String,
    var collectionType: String,
    var amgArtistId: Int,
    var artistName: String,
    var collectionCensoredName: String,
    var artistViewUrl: String,
    var collectionViewUrl: String,
    var artworkUrl60: String,
    var artworkUrl100: String,
    var collectionPrice: Int,
    var collectionExplicitness: String,
    var trackCount: Int,
    var copyright: String,
    var country: String,
    var currency: String,
    var releaseDate: Date,
    var primaryGenreName: String
) : Parcelable {
    constructor(source: Parcel) : this(
    source.readLong(),
    source.readInt(),
    source.readString()!!,
    source.readString()!!,
    source.readInt(),
    source.readString()!!,
    source.readString()!!,
    source.readString()!!,
    source.readString()!!,
    source.readString()!!,
    source.readString()!!,
    source.readInt(),
    source.readString()!!,
    source.readInt(),
    source.readString()!!,
    source.readString()!!,
    source.readString()!!,
    source.readSerializable() as Date,
    source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeInt(artistId)
        writeString(wrapperType)
        writeString(collectionType)
        writeInt(amgArtistId)
        writeString(artistName)
        writeString(collectionCensoredName)
        writeString(artistViewUrl)
        writeString(collectionViewUrl)
        writeString(artworkUrl60)
        writeString(artworkUrl100)
        writeInt(collectionPrice)
        writeString(collectionExplicitness)
        writeInt(trackCount)
        writeString(copyright)
        writeString(country)
        writeString(currency)
        writeSerializable(releaseDate)
        writeString(primaryGenreName)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<AlbumParams> = object : Parcelable.Creator<AlbumParams> {
            override fun createFromParcel(source: Parcel): AlbumParams = AlbumParams(source)
            override fun newArray(size: Int): Array<AlbumParams?> = arrayOfNulls(size)
        }
    }
}