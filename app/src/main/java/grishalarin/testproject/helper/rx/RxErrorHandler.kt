package grishalarin.testproject.helper.rx

import io.reactivex.exceptions.OnErrorNotImplementedException
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.functions.Consumer
import ru.digipeople.logger.LoggerFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

/**
 * @author Sostavkin Grisha
 */
class RxErrorHandler : Consumer<Throwable> {

    private val logger = LoggerFactory.getLogger(RxErrorHandler::class.java)

    override fun accept(throwable: Throwable) {
        val original: Throwable = if (throwable is UndeliverableException) {
            throwable.cause!!
        } else {
            throwable
        }
        when (original) {
            is UnknownHostException -> logger.trace("skipping UnknownHostException")
            is ConnectException -> logger.trace("skipping ConnectException")
            is SSLHandshakeException -> logger.trace("skipping SSLHandshakeException")
            is SocketTimeoutException -> logger.trace("skipping SocketTimeoutException")
            is NullPointerException -> logger.trace("skipping NullPointerException")
            is OnErrorNotImplementedException -> logger.trace("skipping OnErrorNotImplementedException")
            else -> throw RuntimeException(throwable)
        }
    }
}