package com.example.stylosense.presentations.graph.detail_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.example.stylosense.presentations.common.Const
import com.example.stylosense.presentations.graph.Graph


fun NavGraphBuilder.detailNavigationGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS_GRAPH,
        startDestination = DetailPage.TaylorDetailPage.route + "/{${Const.PRODUCT_ID_PARAM}}"
    ) {
//        composable(DetailPage.CartScreen.route) {
//            CartScreen()
//        }
//        composable(DetailPage.NotificationScreen.route) {
//            NotificationScreen()
//        }
//        composable(DetailPage.ProductDetailScreen.route + "/{productId}") {
//            TailorDetailsScreen() {
//                navController.popBackStack()
//            }
//        }
//        composable(DetailPage.ChatDetailScreen.route) {
//            ChatDetailScreen()
//        }
    }
}