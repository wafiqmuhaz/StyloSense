package com.example.stylosense.presentations.page.dashboard_page.dashboard_state

import com.example.stylosense.presentations.model.TaylorModel

data class TaylorState(
    val isLoading: Boolean = false,
    val product: List<TaylorModel>? = null,
    val errorMessage: String = ""
)