package com.example.stylosense.presentations.items

import com.example.stylosense.presentations.model.TaylorModel

interface TaylorRepository {
    suspend fun getProduct(): List<TaylorModel>? = null
    suspend fun getProductDetail(id: Int): TaylorModel? = null
}