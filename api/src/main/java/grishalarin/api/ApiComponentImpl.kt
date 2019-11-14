package grishalarin.api

import dagger.Component
import javax.inject.Singleton

/**
 * @author Sostavkin Grisha
 */
@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponentImpl: ApiComponent