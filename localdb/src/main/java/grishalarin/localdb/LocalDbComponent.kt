package grishalarin.localdb

import grishalarin.localdb.repository.AlbumRepository
import ru.digipeople.database.DbTransaction

/**
 * @author Sostavkin Grisha
 */
interface LocalDbComponent {

    fun dbTransaction(): DbTransaction

    fun albumRepository(): AlbumRepository

    companion object {
        private lateinit var instance: LocalDbComponent

        fun get(): LocalDbComponent = instance

        fun set(localDbComponent: LocalDbComponent) {
            instance = localDbComponent
        }
    }
}