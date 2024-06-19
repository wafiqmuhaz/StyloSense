package com.example.stylosense.presentations.graph.detail_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.stylosense.presentations.common.Const
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.page.cart_page.CartPage
import com.example.stylosense.presentations.page.detail_chat_page.ChatDetailPage
import com.example.stylosense.presentations.page.notif_page.NotificationPage


fun NavGraphBuilder.detailNavigationGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS_GRAPH,
        startDestination = DetailPage.TaylorDetailPage.route + "/{${Const.PRODUCT_ID_PARAM}}"
    ) {
        composable(DetailPage.CartPage.route) {
            CartPage()
        }
        composable(DetailPage.NotificationPage.route) {
            NotificationPage()
        }
        composable(DetailPage.ChatDetailPage.route) {
            ChatDetailPage()
        }
    }
}