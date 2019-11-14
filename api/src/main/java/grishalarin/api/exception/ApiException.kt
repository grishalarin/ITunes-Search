package grishalarin.api.exception

import androidx.annotation.NonNull
import grishalarin.api.model.ApiError
import grishalarin.api.response.Response

/**
 * @author Sostavkin Grisha
 */
class ApiException : Exception {

    var statusCode: Int = 0
        private set

    private lateinit var error: ApiError

    constructor()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)

    constructor(statusCode: Int) {
        this.statusCode = statusCode
    }

    constructor(cause: Throwable, statusCode: Int) : super(cause) {
        this.statusCode = statusCode
    }

    constructor(@NonNull response: Response<*>) {
        this.statusCode = response.code!!
    }

    constructor(message: String, statusCode: Int) : super(message) {
        this.statusCode = statusCode
    }

    constructor(statusCode: Int, error: ApiError) : this(statusCode) {
        this.error = error
    }
}