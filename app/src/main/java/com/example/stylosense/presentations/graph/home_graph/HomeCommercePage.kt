package com.example.stylosense.presentations.graph.home_graph


sealed class ShopHomePage(val route: String) {
    object DashboardPage : ShopHomePage("dashboard_screen")
    object ChatPage : ShopHomePage("conversation_screen")
    object EditProfileScreen : ShopHomePage("edit_profile_screen")
    object ProfilePage : ShopHomePage("profile_screen")
    object FavouritePage : ShopHomePage("favourite_screen")
    object TailorListScreen : ShopHomePage("tailor_list_screen")


    object ProfileDetailScreen : ShopHomePage("profile_detail_screen")
    object SettingsScreen : ShopHomePage("settings_screen")
    object NotificationScreen : ShopHomePage("notification_screen")
    object HelpCenterScreen : ShopHomePage("help_center_screen")
    object LogoutScreen : ShopHomePage("logout_screen")
    // Feature Screen
    object FeaturePage : ShopHomePage("feature_screen")

    object FeatureScreen2 : ShopHomePage("feature_screen_2")
    object FeatureScreen3 : ShopHomePage("feature_screen_3")
    object FeatureScreen4 : ShopHomePage("feature_screen_4")
    //Taylor&Laundry
    object TaylorScreen : ShopHomePage("taylor_screen")
    object LaundryPage : ShopHomePage("laundry_screen")
    object TaylorDetailScreen : ShopHomePage("detail_taylor")
    object LaundryDetailScreen : ShopHomePage("detail_laundry")
//    object FeatureScreen4 : ShopHomePage("feature_screen_4")
}
