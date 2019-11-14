package grishalarin.localdb

import dagger.Component
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
@Component(modules = [LocalDbModule::class])
interface LocalDbComponentImpl : LocalDbComponent