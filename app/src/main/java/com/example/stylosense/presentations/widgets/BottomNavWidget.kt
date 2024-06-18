package com.example.stylosense.presentations.widgets

import com.example.stylosense.R
import com.example.stylosense.presentations.graph.home_graph.ShopHomePage


sealed class BottomNavItem(val tittle: String, val icon: Int, val route: String) {
    object HomeNav : BottomNavItem(
        tittle = "Home",
        icon = R.drawable.ic_home,
        route = ShopHomePage.DashboardScreen.route
    )

    object FavouriteNav : BottomNavItem(
        tittle = "Activity",
        icon = R.drawable.bill_icon,
        route = ShopHomePage.FavouriteScreen.route
    )

    object FeatureNav : BottomNavItem(
        tittle = "Feature",
        icon = R.drawable.phone,
        route = ShopHomePage.FeatureScreen.route
    )

    object ChatNav : BottomNavItem(
        tittle = "Chat",
        icon = R.drawable.chat_bubble_icon,
        route = ShopHomePage.ChatScreen.route
    )

    object ProfileNav : BottomNavItem(
        tittle = "Profile",
        icon = R.drawable.user_icon,
        route = ShopHomePage.ProfileScreen.route
    )
}
