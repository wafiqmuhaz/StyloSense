package com.example.stylosense.presentations.items

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val repository: ProductRepository) {
//    operator fun invoke(productId: Int): Flow<Resource<ProductModel>> = flow {
//        try {
//            emit(Resource.Loading())
//            val data = repository.getProductDetail(productId)
//            emit(Resource.Success(data = data))
//        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
//        }
//    }

}