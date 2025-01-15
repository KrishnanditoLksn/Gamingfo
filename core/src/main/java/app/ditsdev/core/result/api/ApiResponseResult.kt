package app.ditsdev.core.result.api

sealed class ApiResponseResult<out R> {
    data class Success<out T>(val data: T) : ApiResponseResult<T>()
    data class Error(val errorMessage: String) : ApiResponseResult<Nothing>()
    data object Empty : ApiResponseResult<Nothing>()
}