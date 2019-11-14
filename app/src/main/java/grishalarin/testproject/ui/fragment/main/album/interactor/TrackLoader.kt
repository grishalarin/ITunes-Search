package grishalarin.testproject.ui.fragment.main.album.interactor

import grishalarin.api.apiworker.ApiWorker
import grishalarin.localdb.model.Track
import grishalarin.testproject.ui.fragment.main.album.mapper.TrackMapper
import io.reactivex.Single
import ru.digipeople.logger.LoggerFactory
import javax.inject.Inject

/**
 * @author Sostavkin Grisha
 */
class TrackLoader @Inject constructor(
    private val apiWorker: ApiWorker,
    private val trackMapper: TrackMapper
) {

    private val logger = LoggerFactory.getLogger(TrackLoader::class)

    fun getAlbums(albumId: Int): Single<List<Track>> {
        return apiWorker.getAlbum(albumId)
            .map { response ->
                trackMapper.resultsToTracks(response.data?.tracks!!)
            }
            .onErrorReturn {
                logger.error(it!!)
                emptyList()
            }
    }
}