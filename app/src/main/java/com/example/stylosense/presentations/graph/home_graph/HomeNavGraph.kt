package com.example.stylosense.presentations.graph.home_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.graph.detail_graph.detailNavGraph


@Composable
fun HomeNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME_GRAPH,
        startDestination = ShopHomePage.DashboardScreen.route
    ) {
//        composable(ShopHomeScreen.DashboardScreen.route) {
//            DashboardScreen(
//                navController = navHostController
//            ) { productId ->
//                navHostController.navigate(DetailScreen.ProductDetailScreen.route + "/${productId}")
//            }
//        }
//        composable(ShopHomeScreen.TailorListScreen.route) {
//            TailorListScreen()
//        }
//        composable(ShopHomeScreen.FavouriteScreen.route) {
//            FavouriteScreen()
//        }
//        composable(ShopHomeScreen.ChatScreen.route) {
//            ChatScreen()
//        }
//        composable(ShopHomeScreen.EditProfileScreen.route) {
//            EditProfileScreen(navController = navHostController)
//        }
//        composable(ShopHomeScreen.ProfileDetailScreen.route) {
//            ProfileDetailScreen(navController = navHostController)
//        }
//        composable(ShopHomeScreen.FeatureScreen.route) {
//            FeatureScreen(navController = navHostController)
//        }
//        composable(ShopHomeScreen.SettingsScreen.route) {
//            SettingsScreen()
//        }
//        composable(ShopHomeScreen.HelpCenterScreen.route) {
//            HelpCenterScreen()
//        }
//        composable(ShopHomeScreen.ProfileScreen.route) {
////            ProfileScreen() {
////                navHostController.popBackStack()
////            }
//            ProfileScreen(navController = navHostController)
//        }
//        composable(ShopHomeScreen.FeatureScreen2.route) {
//            FeatureScreen2(navController = navHostController)
//        }
//        composable(ShopHomeScreen.FeatureScreen3.route) {
//            FeatureScreen3(navController = navHostController)
//        }
//        composable(ShopHomeScreen.FeatureScreen4.route) {
//            FeatureScreen4(navController = navHostController)
//        }
//        //
//        composable(ShopHomeScreen.TaylorScreen.route) {
//            TaylorScreen()
//        }
//        composable(ShopHomeScreen.TaylorDetailScreen.route) {
//            DetailTaylorScreen()
//        }
//        composable(ShopHomeScreen.LaundryScreen.route) {
//            LaundryScreen()
//        }
//        //detail graph
        detailNavGraph(navController = navHostController)
    }
}