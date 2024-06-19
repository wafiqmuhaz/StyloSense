package com.example.stylosense.presentations.items

import com.example.stylosense.presentations.common.ResourceApp
import com.example.stylosense.presentations.model.TaylorModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val repository: TaylorRepository) {
    operator fun invoke(productId: Int): Flow<ResourceApp<TaylorModel>> = flow {
        try {
            emit(ResourceApp.LoadingApp())
            val data = repository.getProductDetail(productId)
            emit(ResourceApp.SuccessApp(data = data))
        } catch (e: Exception) {
            emit(ResourceApp.ErrorApp(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }

}