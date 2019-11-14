package grishalarin.api.model

import com.google.gson.annotations.SerializedName

/**
 * @author Sostavkin Grisha
 *
 * Модель Api поискового запроса по альбомам
 */
class AlbumsResponse {

    /**
     * Список альбомов
     */
    @SerializedName("results")
    var albums: List<AlbumModelResponse> = emptyList()

    /**
     * Модель альбома
     */
    data class AlbumModelResponse(
        /**
         * Тип возвращаемого объекта
         */
        @SerializedName("wrapperType")
        var wrapperType: String = "",
        /**
         * Тип коллекции
         */
        @SerializedName("collectionType")
        var collectionType: String = "",
        /**
         * Id исполнителя
         */
        @SerializedName("artistId")
        var artistId: Int = 0,
        /**
         * Id коллекции
         */
        @SerializedName("collectionId")
        var id: Int = 0,
        /**
         * All Music Guide artistId исполнителя
         */
        @SerializedName("amgArtistId")
        var amgArtistId: Int = 0,
        /**
         * Имя исполнителя
         */
        @SerializedName("artistName")
        var artistName: String = "",
        /**
         * Название альбома для цензуры
         */
        @SerializedName("collectionCensoredName")
        var collectionCensoredName: String = "",
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
         * Цена
         */
        @SerializedName("collectionPrice")
        var collectionPrice: Int = 0,
        /**
         * The Recording Industry Association of America (RIAA) parental advisory for the content returned by the search request
         */
        @SerializedName("collectionExplicitness")
        var collectionExplicitness: String = "",
        /**
         * Количество треков
         */
        @SerializedName("trackCount")
        var trackCount: Int = 0,
        /**
         * Права
         */
        @SerializedName("copyright")
        var copyright: String = "",
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
         * Дата выпуска альбома
         */
        @SerializedName("releaseDate")
        var releaseDate: String = "",
        /**
         * Жанр
         */
        @SerializedName("primaryGenreName")
        var primaryGenreName: String = ""
    )
}
