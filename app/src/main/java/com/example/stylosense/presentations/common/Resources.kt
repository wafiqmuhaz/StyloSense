package com.example.stylosense.presentations.common

//sealed class ResourceApp<T>(val data: T? = null, val message: String? = null) {
//    class LoadingApp<T>() : ResourceApp<T>()
//    class SuccessApp<T>(data: T? = null) : ResourceApp<T>(data = data)
//    class ErrorApp<T>(message: String? = null) : ResourceApp<T>(message = message)
//}

sealed class ResourceApp<T>(
    val data: T? = null,
    val message: String? = null,
    val status: Status? = null,
    val timestamp: Long = System.currentTimeMillis()
) {
    class LoadingApp<T> : ResourceApp<T>(status = Status.LOADING)
    class SuccessApp<T>(data: T? = null) : ResourceApp<T>(data = data, status = Status.SUCCESS)
    class ErrorApp<T>(message: String? = null, val errorCode: Int? = null) : ResourceApp<T>(message = message, status = Status.ERROR)

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> loading(): ResourceApp<T> = LoadingApp()
        fun <T> success(data: T? = null): ResourceApp<T> = SuccessApp(data)
        fun <T> error(message: String? = null, errorCode: Int? = null): ResourceApp<T> = ErrorApp(message, errorCode)
    }

    fun isLoading(): Boolean = this is LoadingApp
    fun isSuccess(): Boolean = this is SuccessApp
    fun isError(): Boolean = this is ErrorApp

    fun retrieveMessage(): String? = when (this) {
        is LoadingApp -> "Loading..."
        is SuccessApp -> message ?: "Success"
        is ErrorApp -> message ?: "An error occurred"
        else -> {
            "Unknown status"
        }
    }

    fun getDataOrFallback(fallback: T): T = data ?: fallback
}