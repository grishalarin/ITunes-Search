package grishalarin.api.appinfo

/**
 * @author Sostavkin Grisha
 */
class ApplicationInfo (
    val isDebug: Boolean,
    val applicationId: String,
    val buildType: String,
    val flavor: String,
    val versionCode: Int,
    val versionName: String
)
