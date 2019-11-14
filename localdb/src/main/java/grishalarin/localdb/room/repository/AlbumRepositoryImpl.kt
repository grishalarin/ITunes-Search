package grishalarin.localdb.room.repository

import grishalarin.localdb.AppDatabase
import grishalarin.localdb.model.Album
import grishalarin.localdb.repository.AlbumRepository
import grishalarin.localdb.room.entity.AlbumEntity
import grishalarin.localdb.room.mapper.AlbumsMapper
import ru.digipeople.database.room.repository.ModelRepositoryWithLongId
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
class AlbumRepositoryImpl  @Inject constructor(appDatabase: AppDatabase) :
    ModelRepositoryWithLongId<Album, AlbumEntity>(appDatabase), AlbumRepository {

    override val mapper = AlbumsMapper
    override val dao = appDatabase.albumDao()
}