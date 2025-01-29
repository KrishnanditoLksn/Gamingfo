package app.ditsdev.core.data.result.resource

sealed class ResourceResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : ResourceResult<T>(data)
    class Error<T>(message: String, data: T? = null) : ResourceResult<T>(data, message)
    class Loading<T>(data: T?) : ResourceResult<T>(data)
}