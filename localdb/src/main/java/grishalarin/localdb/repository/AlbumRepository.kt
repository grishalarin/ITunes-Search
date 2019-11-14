package grishalarin.localdb.repository

import grishalarin.localdb.model.Album
import ru.digipeople.database.repository.ModelRepository

/**
 * @author Sostavkin Grisha
 */
interface AlbumRepository : ModelRepository<Album, Long>