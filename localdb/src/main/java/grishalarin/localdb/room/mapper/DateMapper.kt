package grishalarin.localdb.room.mapper

import org.mapstruct.Mapper
import java.util.*

/**
 * @author Kashonkov Nikita
 */
@Mapper
open class DateMapper{
    fun entityToModel(entity: Long?): Date? {
        return if (entity == null) {
            null
        } else Date(entity)
    }

    fun modelToEntity(model: Date?): Long? {
        return model?.time
    }
}