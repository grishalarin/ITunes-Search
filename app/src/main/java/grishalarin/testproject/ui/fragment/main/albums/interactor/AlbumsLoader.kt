package grishalarin.testproject.ui.fragment.main.albums.interactor

import grishalarin.api.apiworker.ApiWorker
import grishalarin.localdb.model.Album
import grishalarin.localdb.repository.AlbumRepository
import grishalarin.testproject.ui.fragment.main.albums.mapper.AlbumsMapper
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class AlbumsLoader @Inject constructor(
    private val apiWorker: ApiWorker,
    private val albumsMapper: AlbumsMapper,
    private val albumRepository: AlbumRepository
) {

    fun getAlbums(searchText: String): Single<List<Album>> {
        return apiWorker.getSearchAlbumModelsResponse(searchText)
            .map { response ->
                albumsMapper.resultsToAlbums(response.data!!.albums)
            }
            .onErrorReturn { loadFromDb() }
            .doOnSuccess { storeAlbums(it) }
    }

    fun getAlbumsFromDb(): Single<List<Album>> {
        return Single.fromCallable { albumRepository.getAll() }
    }

    private fun loadFromDb(): List<Album> {
        return albumRepository.getAll()
    }

    private fun storeAlbums(albums: List<Album>) {
        if (albums.isNotEmpty()) {
            albumRepository.deleteAll()
            albumRepository.insert(albums)
        }
    }
}