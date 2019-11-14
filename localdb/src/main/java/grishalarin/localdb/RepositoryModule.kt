package grishalarin.localdb

import dagger.Binds
import dagger.Module
import grishalarin.localdb.repository.AlbumRepository
import grishalarin.localdb.room.repository.AlbumRepositoryImpl

/**
 * @author Sostavkin Grisha
 */
@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun albumRepository(albumRepository: AlbumRepositoryImpl): AlbumRepository
}