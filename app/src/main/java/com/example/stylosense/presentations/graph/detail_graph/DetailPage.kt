package com.example.stylosense.presentations.graph.detail_graph

sealed class DetailPage( val route: String) {
//    object CartScreen : DetailScreen("cart_screen")
//    object NotificationScreen : DetailScreen("notification_screen")
    object ProductDetailPage : DetailPage("product_detail_screen")
//    object ChatDetailScreen : DetailScreen("product_detail_screen")
}