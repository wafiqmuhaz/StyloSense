package com.example.stylosense.presentations.model

import androidx.compose.ui.graphics.Color

data class TaylorModel(
    val id: Int,
    val title: String,
    val images: List<Int>,
    val colors: List<Color>,
    val rating: Double,
//    val price: Double,
    val price: String,
    val isFavourite: Boolean,
    val isPopular: Boolean,
    val description: String
)