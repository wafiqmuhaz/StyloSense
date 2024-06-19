package com.example.stylosense.presentations.widgets

import com.example.stylosense.R
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage


sealed class BottomNavItem(val tittle: String, val icon: Int, val route: String) {
    object HomeNav : BottomNavItem(
        tittle = "Home",
        icon = R.drawable.ic_home,
        route = ShopCommercePage.DashboardPage.route
    )

    object FavouriteNav : BottomNavItem(
        tittle = "Activity",
        icon = R.drawable.bill_icon,
        route = ShopCommercePage.FavouritePage.route
    )

    object FeatureNav : BottomNavItem(
        tittle = "Feature",
        icon = R.drawable.phone,
        route = ShopCommercePage.FeaturePage.route
    )

    object ChatNav : BottomNavItem(
        tittle = "Chat",
        icon = R.drawable.chat_bubble_icon,
        route = ShopCommercePage.ChatPage.route
    )

    object ProfileNav : BottomNavItem(
        tittle = "Profile",
        icon = R.drawable.user_icon,
        route = ShopCommercePage.ProfilePage.route
    )
}
