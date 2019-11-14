package grishalarin.api.apiworker

import grishalarin.api.model.AlbumsResponse
import grishalarin.api.model.TracksResponse
import grishalarin.api.response.Response
import io.reactivex.Single

/**
 * @author Sostavkin Grisha
 */
interface ApiWorker {
    /**
     * Получает список альбомов
     *
     * @param searchText текст для поискового запроса
     */
    fun getSearchAlbumModelsResponse(searchText: String): Single<Response<AlbumsResponse>>

    /**
     * Получает альбом
     *
     * @param albumId текст для поискового запроса
     */
    fun getAlbum(albumId: Int): Single<Response<TracksResponse>>
}