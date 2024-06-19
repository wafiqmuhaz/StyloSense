package com.example.stylosense.presentations.graph.detail_graph

sealed class DetailPage( val route: String) {
    object CartPage : DetailPage("cart_screen")
    object NotificationPage : DetailPage("notification_screen")
    object TaylorDetailPage : DetailPage("product_detail_screen")
    object ChatDetailPage : DetailPage("product_detail_screen")
}