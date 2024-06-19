package com.example.stylosense.items

import com.example.stylosense.presentations.items.TaylorRepository
import com.example.stylosense.presentations.model.TaylorModel
import javax.inject.Inject


class ProductRepositoryImp @Inject constructor(
    private val demoDB: DemoItem
) : TaylorRepository {
    override suspend fun getProduct(): List<TaylorModel> {
        return demoDB.getProduct()
    }

    override suspend fun getProductDetail(id: Int): TaylorModel {
        return demoDB.getProduct()[id-1]
    }
}