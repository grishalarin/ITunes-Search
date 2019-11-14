package grishalarin.localdb.model

/**
 * @author Sostavkin Grisha
 */
enum class WrapperType(val type: String) {
    /**
     * Неизвестно
     */
    UNKNOWN(""),
    /**
     * Трек
     */
    TRACK("track"),
    /**
     * Альбом
     */
    COLLECTION("collection");

    companion object {
        fun valueOf(code: Int) = values().getOrElse(code, { UNKNOWN })
    }
}