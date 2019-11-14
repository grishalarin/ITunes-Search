package grishalarin.localdb.model

import java.util.*

/**
 * @author Sostavkin Grisha
 */
class Track {
    /**
     * Тип возвращаемого объекта
     */
    var wrapperType: WrapperType = WrapperType.UNKNOWN
    /**
     * Тип
     */
    var kind: String = ""
    /**
     * Id исполнителя
     */
    var artistId: Int = 0
    /**
     * Id коллекции
     */
    var collectionId: Int = 0
    /**
     * Id трека
     */
    var trackId: Int = 0
    /**
     * Имя исполнителя
     */
    var artistName: String = ""
    /**
     * Название альбома
     */
    var collectionName: String = ""
    /**
     * Название альбома для цензуры
     */
    var collectionCensoreName: String = ""
    /**
     * Название трека
     */
    var trackName: String = ""
    /**
     * Название трека для цензуры
     */
    var trackCensoreName: String = ""
    /**
     * Ссылка на артиста
     */
    var artistViewUrl: String = ""
    /**
     * Ссылка на альбом
     */
    var collectionViewUrl: String = ""
    /**
     * ССылка на трек
     */
    var trackViewUrl: String = ""
    /**
     * ССылка на превью трека
     */
    var previewUrl: String = ""
    /**
     * Url картинки в разрешении 30*30 пикселей
     */
    var artworkUrl30: String = ""
    /**
     * Url картинки в разрешении 60*60 пикселей
     */
    var artworkUrl60: String = ""
    /**
     * Url картинки в разрешении 100*100 пикселей
     */
    var artworkUrl100: String = ""
    /**
     * Цена альбома
     */
    var collectionPrice: Int = 0
    /**
     * Цена трека
     */
    var trackPrice: Int = 0
    /**
     * Дата выпуска
     */
    var releaseDate: Date = Date()
    /**
     * The Recording Industry Association of America (RIAA) parental advisory for the content returned by the album
     */
    var collectionExplicitness: String = ""
    /**
     * The Recording Industry Association of America (RIAA) parental advisory for the content returned by the track
     */
    var trackExplicitness: String = ""
    /**
     * Количество дисков
     */
    var discCount: Int = 0
    /**
     * Номер дисков
     */
    var discNumber: Int = 0
    /**
     * Количество треков
     */
    var trackCount: Int = 0
    /**
     * Количество треков
     */
    var trackNumber: Int = 0
    /**
     * Продолжительность трека
     */
    var trackTime: Date = Date()
    /**
     * Страна
     */
    var country: String = ""
    /**
     * Валюта
     */
    var currency: String = ""
    /**
     * Жанр
     */
    var primaryGenreName: String = ""
    /**
     * Потоковый
     */
    var isStreamable: Boolean = false
}