package grishalarin.localdb.room.mapper

import grishalarin.localdb.model.Album
import grishalarin.localdb.room.entity.AlbumEntity
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import ru.digipeople.database.room.mapper.BaseMapper

/**
 * @author Sostavkin Grisha
 */
@Mapper(uses = [DateMapper::class])
interface AlbumsMapper : BaseMapper<Album, AlbumEntity> {
    companion object : AlbumsMapper by INSTANCE
}

private val INSTANCE = Mappers.getMapper<AlbumsMapper>(AlbumsMapper::class.java)
