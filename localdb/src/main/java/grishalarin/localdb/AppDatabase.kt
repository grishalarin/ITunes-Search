package grishalarin.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import grishalarin.localdb.room.dao.AlbumDao
import grishalarin.localdb.room.entity.AlbumEntity

/**
 * @author Sostavkin Grisha
 */
@Database(version = BuildConfig.DB_VERSION, exportSchema = false, entities = [AlbumEntity::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao
}
