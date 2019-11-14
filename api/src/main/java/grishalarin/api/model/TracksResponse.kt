package grishalarin.api.model

import com.google.gson.annotations.SerializedName

/**
 * @author Sostavkin Grisha
 */
class TracksResponse {

    /**
     * Список треков
     */
    @SerializedName("results")
    var tracks: List<TrackResponse> = emptyList()

    /**
     * Модель трека
     */
    data class TrackResponse(
        /**
         * Тип возвращаемого объекта
         */
        @SerializedName("wrapperType")
        var wrapperType: String = "",
        /**
         * Тип
         */
        @SerializedName("kind")
        var kind: String = "",
        /**
         * Id исполнителя
         */
        @SerializedName("artistId")
        var artistId: Int = 0,
        /**
         * Id коллекции
         */
        @SerializedName("collectionId")
        var collectionId: Int = 0,
        /**
         * Id трека
         */
        @SerializedName("trackId")
        var trackId: Int = 0,
        /**
         * Имя исполнителя
         */
        @SerializedName("artistName")
        var artistName: String = "",
        /**
         * Название альбома
         */
        @SerializedName("collectionName")
        var collectionName: String = "",
        /**
         * Название альбома для цензуры
         */
        @SerializedName("collectionCensoredName")
        var collectionCensoreName: String = "",
        /**
         * Название трека
         */
        @SerializedName("trackName")
        var trackName: String = "",
        /**
         * Название трека для цензуры
         */
        @SerializedName("trackCensoredName")
        var trackCensoreName: String = "",
        /**
         * Ссылка на артиста
         */
        @SerializedName("artistViewUrl")
        var artistViewUrl: String = "",
        /**
         * Ссылка на альбом
         */
        @SerializedName("collectionViewUrl")
        var collectionViewUrl: String = "",
        /**
         * ССылка на трек
         */
        @SerializedName("trackViewUrl")
        var trackViewUrl: String = "",
        /**
         * ССылка на превью трека
         */
        @SerializedName("previewUrl")
        var previewUrl: String = "",
        /**
         * Url картинки в разрешении 30*30 пикселей
         */
        @SerializedName("artworkUrl30")
        var artworkUrl30: String = "",
        /**
         * Url картинки в разрешении 60*60 пикселей
         */
        @SerializedName("artworkUrl60")
        var artworkUrl60: String = "",
        /**
         * Url картинки в разрешении 100*100 пикселей
         */
        @SerializedName("artworkUrl100")
        var artworkUrl100: String = "",
        /**
         * Цена альбома
         */
        @SerializedName("collectionPrice")
        var collectionPrice: Int = 0,
        /**
         * Цена трека
         */
        @SerializedName("trackPrice")
        var trackPrice: Int = 0,
        /**
         * Дата выпуска
         */
        @SerializedName("releaseDate")
        var releaseDate: String = "",
        /**
         * The Recording Industry Association of America (RIAA) parental advisory for the content returned by the album
         */
        @SerializedName("collectionExplicitness")
        var collectionExplicitness: String = "",
        /**
         * The Recording Industry Association of America (RIAA) parental advisory for the content returned by the track
         */
        @SerializedName("trackExplicitness")
        var trackExplicitness: String = "",
        /**
         * Количество дисков
         */
        @SerializedName("discCount")
        var discCount: Int = 0,
        /**
         * Номер дисков
         */
        @SerializedName("discNumber")
        var discNumber: Int = 0,
        /**
         * Количество треков
         */
        @SerializedName("trackCount")
        var trackCount: Int = 0,
        /**
         * Количество треков
         */
        @SerializedName("trackNumber")
        var trackNumber: Int = 0,
        /**
         * Продолжительность трека
         */
        @SerializedName("trackTimeMillis")
        var trackTime: Long = 0,
        /**
         * Страна
         */
        @SerializedName("country")
        var country: String = "",
        /**
         * Валюта
         */
        @SerializedName("currency")
        var currency: String = "",
        /**
         * Жанр
         */
        @SerializedName("primaryGenreName")
        var primaryGenreName: String = "",
        /**
         * Жанр
         */
        @SerializedName("isStreamable")
        var isStreamable: Boolean = false
    )
}