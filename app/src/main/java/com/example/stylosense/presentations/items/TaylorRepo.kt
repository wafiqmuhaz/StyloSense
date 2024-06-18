package com.example.stylosense.presentations.items

import com.example.stylosense.presentations.model.TaylorModel

interface ProductRepository {
    suspend fun getProduct(): List<TaylorModel>? = null
    suspend fun getProductDetail(id: Int): TaylorModel? = null
}