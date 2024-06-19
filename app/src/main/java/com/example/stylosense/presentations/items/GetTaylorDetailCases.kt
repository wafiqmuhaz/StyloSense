package com.example.stylosense.presentations.items

import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(private val repository: TaylorRepository) {
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