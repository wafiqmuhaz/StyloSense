package com.example.stylosense.core_item.case_taylor

import com.example.stylosense.presentations.common.ResourceApp
import com.example.stylosense.presentations.items.TaylorRepository
import com.example.stylosense.presentations.model.TaylorModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTaylorDetailCase @Inject constructor(private val repository: TaylorRepository) {
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