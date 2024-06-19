package com.example.stylosense.presentations.graph.home_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.graph.detail_graph.DetailPage
import com.example.stylosense.presentations.graph.detail_graph.detailNavigationGraph
import com.example.stylosense.presentations.page.chat_page.ChatPage
import com.example.stylosense.presentations.page.dashboard_page.DashboardPage
import com.example.stylosense.presentations.page.detail_taylor_page.component.DetailTaylorPage
import com.example.stylosense.presentations.page.fav_page.FavouritePage
import com.example.stylosense.presentations.page.laundry_page.LaundryPage
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage2
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage3
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage4
import com.example.stylosense.presentations.page.profile_page.ProfilePage
import com.example.stylosense.presentations.page.profile_page.help_center_page.HelpCenterPage
import com.example.stylosense.presentations.page.profile_page.profile_edit_user_page.EditProfilePage
import com.example.stylosense.presentations.page.profile_page.profile_user_page.ProfileDetailPage
import com.example.stylosense.presentations.page.profile_page.setting_page.SettingsPage
import com.example.stylosense.presentations.page.tailor_list_page.TailorListPage
import com.example.stylosense.presentations.page.taylor_page.TaylorPage


@Composable
fun HomeNavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME_GRAPH,
        startDestination = ShopCommercePage.DashboardPage.route
    ) {
        composable(ShopCommercePage.DashboardPage.route) {
            DashboardPage(
                navController = navHostController
            ) { productId ->
                navHostController.navigate(DetailPage.TaylorDetailPage.route + "/${productId}")
            }
        }
        composable(ShopCommercePage.TailorListPage.route) {
            TailorListPage()
        }
        composable(ShopCommercePage.FavouritePage.route) {
            FavouritePage()
        }
        composable(ShopCommercePage.ChatPage.route) {
            ChatPage()
        }
        composable(ShopCommercePage.EditProfilePage.route) {
            EditProfilePage(navController = navHostController)
        }
        composable(ShopCommercePage.ProfileDetailPage.route) {
            ProfileDetailPage(navController = navHostController)
        }
        composable(ShopCommercePage.FeaturePage.route) {
            FeaturePage(navController = navHostController)
        }
        composable(ShopCommercePage.SettingsPage.route) {
            SettingsPage()
        }
        composable(ShopCommercePage.HelpCenterPage.route) {
            HelpCenterPage()
        }
        composable(ShopCommercePage.ProfilePage.route) {
//            ProfilePage() {
//                navHostController.popBackStack()
//            }
            ProfilePage(navController = navHostController)
        }
        composable(ShopCommercePage.FeaturePage2.route) {
            FeaturePage2(navController = navHostController)
        }
        composable(ShopCommercePage.FeaturePage3.route) {
            FeaturePage3(navController = navHostController)
        }
        composable(ShopCommercePage.FeaturePage4.route) {
            FeaturePage4(navController = navHostController)
        }
        //
        composable(ShopCommercePage.TaylorPage.route) {
            TaylorPage()
        }
        composable(ShopCommercePage.TaylorDetailPage.route) {
            DetailTaylorPage()
        }
        composable(ShopCommercePage.LaundryPage.route) {
            LaundryPage()
        }
//        //detail graph
        detailNavigationGraph(navController = navHostController)
    }
}