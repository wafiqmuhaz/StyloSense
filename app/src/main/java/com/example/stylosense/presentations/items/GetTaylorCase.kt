package com.example.stylosense.presentations.items

import com.example.stylosense.presentations.common.ResourceApp
import com.example.stylosense.presentations.model.TaylorModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: TaylorRepository
) {
    operator fun invoke(): Flow<ResourceApp<List<TaylorModel>>> = flow {
        try {
            emit(ResourceApp.LoadingApp())
            val products = repository.getProduct()?.map { it }
            emit(ResourceApp.SuccessApp(data = products))
        } catch (e: Exception) {
            emit(ResourceApp.ErrorApp(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}