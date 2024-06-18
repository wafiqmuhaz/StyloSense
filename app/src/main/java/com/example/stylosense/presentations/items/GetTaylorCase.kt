package com.example.stylosense.presentations.items

import com.example.stylosense.presentations.common.Resource
import com.example.stylosense.presentations.model.TaylorModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<Resource<List<TaylorModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProduct()?.map { it }
            emit(Resource.Success(data = products))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}