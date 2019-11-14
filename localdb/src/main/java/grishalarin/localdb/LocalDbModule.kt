package grishalarin.localdb

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.digipeople.database.DbTransaction
import ru.digipeople.database.room.DbTransactionImpl
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Module(includes = [RepositoryModule::class])
class LocalDbModule(private val context: Context) {

    @Provides
    @Singleton
    fun appDatabase() = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun dbTransaction(appDatabase: AppDatabase): DbTransaction = DbTransactionImpl(appDatabase)

    companion object {
        /**
         * Имя файла БД
         */
        private const val DB_NAME = "album.db"
    }
}