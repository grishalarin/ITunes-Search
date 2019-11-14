package grishalarin.api

import grishalarin.api.model.AlbumsResponse
import grishalarin.api.model.TracksResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Sostavkin Grisha
 */
interface Api {
    /**
     * Получает список альбомов
     *
     * @param searchText текст для поискового запроса
     * @param country страна поиска
     * @param media тип мультимедиа
     * @param entity сущность мультимедиа, например: Альбом, Трек
     */
    @GET("search?")
    fun getSearchAlbumModels(
        @Query("term") searchText: String,
        @Query("country") country: String,
        @Query("media") media: String,
        @Query("entity") entity: String
    ): Single<Response<AlbumsResponse>>

    /**
     * Получает альбом
     *
     * @param searchText текст для поискового запроса
     * @param country страна поиска
     * @param media тип мультимедиа
     * @param entity сущность мультимедиа, например: Альбом, Трек
     * @param attribute атрибут
     */
    @GET("lookup?")
    fun getAlbum(
        @Query("id") albumId: Int,
        @Query("country") country: String,
        @Query("entity") entity: String
    ): Single<Response<TracksResponse>>

}