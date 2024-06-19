package com.example.stylosense.presentations.graph.home_graph


sealed class ShopCommercePage(val route: String) {
    object DashboardPage : ShopCommercePage("dashboard_screen")
    object ChatPage : ShopCommercePage("conversation_screen")
    object EditProfileScreen : ShopCommercePage("edit_profile_screen")
    object ProfilePage : ShopCommercePage("profile_screen")
    object FavouritePage : ShopCommercePage("favourite_screen")
    object TailorListScreen : ShopCommercePage("tailor_list_screen")


    object ProfileDetailScreen : ShopCommercePage("profile_detail_screen")
    object SettingsScreen : ShopCommercePage("settings_screen")
    object NotificationScreen : ShopCommercePage("notification_screen")
    object HelpCenterScreen : ShopCommercePage("help_center_screen")
    object LogoutScreen : ShopCommercePage("logout_screen")
    // Feature Screen
    object FeaturePage : ShopCommercePage("feature_screen")

    object FeatureScreen2 : ShopCommercePage("feature_screen_2")
    object FeatureScreen3 : ShopCommercePage("feature_screen_3")
    object FeatureScreen4 : ShopCommercePage("feature_screen_4")
    //Taylor&Laundry
    object TaylorScreen : ShopCommercePage("taylor_screen")
    object LaundryPage : ShopCommercePage("laundry_screen")
    object TaylorDetailScreen : ShopCommercePage("detail_taylor")
    object LaundryDetailScreen : ShopCommercePage("detail_laundry")
//    object FeatureScreen4 : ShopCommercePage("feature_screen_4")
}
