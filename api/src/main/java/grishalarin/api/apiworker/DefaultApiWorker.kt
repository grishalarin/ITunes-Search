package grishalarin.api.apiworker

import grishalarin.api.Api
import grishalarin.api.BuildConfig
import grishalarin.api.model.AlbumsResponse
import grishalarin.api.model.TracksResponse
import grishalarin.api.response.Response
import grishalarin.api.response.ResponseConverter
import io.reactivex.Single

/**
 * @author Sostavkin Grisha
 */
class DefaultApiWorker(
    private val api: Api,
    private val responseConverter: ResponseConverter
) : ApiWorker {

    override fun getSearchAlbumModelsResponse(searchText: String): Single<Response<AlbumsResponse>> {
        return api.getSearchAlbumModels(
            searchText,
            BuildConfig.COUNTRY,
            BuildConfig.MEDIA,
            BuildConfig.ALBUM_ENTITY
        )
            .map { response -> responseConverter.convert(response) }
    }

    override fun getAlbum(albumId: Int): Single<Response<TracksResponse>> {
        return api.getAlbum(albumId, BuildConfig.COUNTRY, BuildConfig.SONG_ENTITY)
            .map { response -> responseConverter.convert(response) }
    }
}