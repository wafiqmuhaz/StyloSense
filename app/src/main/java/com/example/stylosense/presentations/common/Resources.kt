package com.example.stylosense.presentations.common

sealed class ResourceApp<T>(val data: T? = null, val message: String? = null) {
    class LoadingApp<T>() : ResourceApp<T>()
    class SuccessApp<T>(data: T? = null) : ResourceApp<T>(data = data)
    class ErrorApp<T>(message: String? = null) : ResourceApp<T>(message = message)
}