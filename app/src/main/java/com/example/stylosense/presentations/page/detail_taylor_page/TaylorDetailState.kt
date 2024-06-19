package com.example.stylosense.presentations.page.detail_taylor_page

import com.example.stylosense.presentations.model.TaylorModel


data class TaylorDetailState(
    val isLoading: Boolean = false,
    val productDetail: TaylorModel? = null,
    val errorMessage: String = ""
)