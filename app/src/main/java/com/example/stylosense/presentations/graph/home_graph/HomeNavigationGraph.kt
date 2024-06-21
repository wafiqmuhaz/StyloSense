package com.example.stylosense.presentations.graph.home_graph

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosense.presentations.detail_chat_taylor_page.DetailChatTaylorPage
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.graph.detail_graph.DetailPage
import com.example.stylosense.presentations.graph.detail_graph.detailNavigationGraph
import com.example.stylosense.presentations.model.ChatViewModel
import com.example.stylosense.presentations.page.activity_order_details_page.ActivityOrderDetailsPage
import com.example.stylosense.presentations.page.chat_page.ChatPage
import com.example.stylosense.presentations.page.dashboard_page.DashboardPage
import com.example.stylosense.presentations.page.detail_taylor_page.component.DetailTaylorPage
import com.example.stylosense.presentations.page.fav_page.FavouritePage
import com.example.stylosense.presentations.page.laundry_page.LaundryPage
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage2
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage3
import com.example.stylosense.presentations.page.ml_feature_page.FeaturePage4
import com.example.stylosense.presentations.page.ml_feature_page.MainViewModel
import com.example.stylosense.presentations.page.order_summery_page.OrderSummaryPage
import com.example.stylosense.presentations.page.otp_page.OTPPage
import com.example.stylosense.presentations.page.payment_method_page.PaymentMethodPage
import com.example.stylosense.presentations.page.profile_page.ProfilePage
import com.example.stylosense.presentations.page.profile_page.help_center_page.HelpCenterPage
import com.example.stylosense.presentations.page.profile_page.profile_edit_user_page.EditProfilePage
import com.example.stylosense.presentations.page.profile_page.profile_user_page.ProfileDetailPage
import com.example.stylosense.presentations.page.profile_page.setting_page.SettingsPage
import com.example.stylosense.presentations.page.success_payment_page.SuccessPaymentPage
import com.example.stylosense.presentations.page.tailor_list_page.TailorListPage
import com.example.stylosense.presentations.page.tailor_list_page.getTailorById
import com.example.stylosense.presentations.page.taylor_page.TaylorPage
import com.example.stylosense.presentations.page.track_order_page.TrackOrderPage

@Composable
fun HomeNavigationGraph(viewModel: MainViewModel, navHostController: NavHostController) {
    val viewModelStoreOwner = LocalViewModelStoreOwner.current

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
            TailorListPage(navController = navHostController)
        }
        composable(ShopCommercePage.FavouritePage.route) {
            FavouritePage(navController = navHostController)
        }
        composable(ShopCommercePage.ChatPage.route) {
            ChatPage(navController = navHostController)
        }
        viewModelStoreOwner?.let { owner ->
            composable(
                ShopCommercePage.DetailChatTaylorPage.route
//                "detail_chat_taylor_screen"
            ) {
                val chatViewModel: ChatViewModel = viewModel(
                    modelClass = ChatViewModel::class.java,
                    viewModelStoreOwner = owner
                )
                DetailChatTaylorPage(modifier = Modifier.padding(), chatViewModel)
            }
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
            ProfilePage(navController = navHostController)
        }
        composable(ShopCommercePage.FeaturePage2.route) {
            FeaturePage2(navController = navHostController)
        }
        composable(ShopCommercePage.FeaturePage3.route) {
            FeaturePage3(navController = navHostController, viewModel)
        }
        composable(ShopCommercePage.FeaturePage4.route) {
            FeaturePage4(viewModel)
        }
        composable(ShopCommercePage.TaylorPage.route) {
            TaylorPage()
        }
        composable(ShopCommercePage.TrackOrderPage.route) {
            TrackOrderPage()
        }
        composable("detail/{tailorId}") { backStackEntry ->
            val tailorId = backStackEntry.arguments?.getString("tailorId")
            if (tailorId != null) {
                DetailTaylorPage(navController = navHostController, backStackEntry)
            }
        }
        composable("order_detail/{tailorId}") { backStackEntry ->
            val tailorId = backStackEntry.arguments?.getString("tailorId")
            if (tailorId != null) {
                ActivityOrderDetailsPage(navController = navHostController, backStackEntry)
            }
        }
        composable("summary/{tailorId}") { backStackEntry ->
            val tailorId = backStackEntry.arguments?.getString("tailorId")
            if (tailorId != null) {
                OrderSummaryPage(navController = navHostController, backStackEntry)
            }
        }
        composable(ShopCommercePage.LaundryPage.route) {
            LaundryPage()
        }
        composable(ShopCommercePage.PaymentMethodPage.route) {
            PaymentMethodPage(navController = navHostController)
        }
        composable(ShopCommercePage.SuccessPaymentPage.route) {
            SuccessPaymentPage(navController = navHostController)
        }
        composable(ShopCommercePage.OTPPage.route) {
            OTPPage(navController = navHostController)
        }
        detailNavigationGraph(navController = navHostController)
    }
}