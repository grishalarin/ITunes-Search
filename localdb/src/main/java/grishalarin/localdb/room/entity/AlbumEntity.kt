package grishalarin.localdb.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.digipeople.database.room.entity.EntityWithId

/**
 * @author Sostavkin Grisha
 */
@Entity(tableName = "Album")
class AlbumEntity : EntityWithId<Long> {
    /**
     * Id коллекции
     */
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0
    /**
     * Id исполнителя
     */
    var artistId: Int = 0
    /**
     * Тип возвращаемого объекта
     */
    var wrapperType: String = ""
    /**
     * Тип коллекции
     */
    var collectionType: String = ""
    /**
     * All Music Guide collectionId исполнителя
     */
    var amgArtistId: Int = 0
    /**
     * Имя исполнителя
     */
    var artistName: String = ""
    /**
     * Название альбома для цензуры
     */
    var collectionCensoredName: String = ""
    /**
     * Ссылка на артиста
     */
    var artistViewUrl: String = ""
    /**
     * Ссылка на альбом
     */
    var collectionViewUrl: String = ""
    /**
     * Url картинки в разрешении 60*60 пикселей
     */
    var artworkUrl60: String = ""
    /**
     * Url картинки в разрешении 100*100 пикселей
     */
    var artworkUrl100: String = ""
    /**
     * Цена
     */
    var collectionPrice: Int = 0
    /**
     * The Recording Industry Association of America (RIAA) parental advisory for the content returned by the search request
     */
    var collectionExplicitness: String = ""
    /**
     * Количество треков
     */
    var trackCount: Int = 0
    /**
     * Права
     */
    var copyright: String = ""
    /**
     * Страна
     */
    var country: String = ""
    /**
     * Валюта
     */
    var currency: String = ""
    /**
     * Дата выпуска альбома
     */
    var releaseDate: Long = 0
    /**
     * Жанр
     */
    var primaryGenreName: String = ""
}