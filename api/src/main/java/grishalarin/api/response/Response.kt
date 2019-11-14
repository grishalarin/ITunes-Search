package grishalarin.api.response

import grishalarin.api.model.ApiError

/**
 * @author Sostavkin Grisha
 */
class Response<T> internal constructor(val data: T?, val error: ApiError?, val code: Int?) {

    /**
     * Returns true if the code is in [200..300), which means the request was successfully received,
     * understood, and accepted [okhttp3.Response.isSuccessful]
     */
    val isSuccessful: Boolean
        get() = code in 200..299
}