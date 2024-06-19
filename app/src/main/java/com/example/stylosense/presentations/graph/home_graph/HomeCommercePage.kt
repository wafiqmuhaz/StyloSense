package com.example.stylosense.presentations.graph.home_graph


sealed class ShopCommercePage(val route: String) {
    object DashboardPage : ShopCommercePage("dashboard_screen")
    object ChatPage : ShopCommercePage("conversation_screen")
    object EditProfilePage : ShopCommercePage("edit_profile_screen")
    object ProfilePage : ShopCommercePage("profile_screen")
    object FavouritePage : ShopCommercePage("favourite_screen")
    object TailorListPage : ShopCommercePage("tailor_list_screen")


    object ProfileDetailPage : ShopCommercePage("profile_detail_screen")
    object SettingsPage : ShopCommercePage("settings_screen")
    object NotificationPage : ShopCommercePage("notification_screen")
    object HelpCenterPage : ShopCommercePage("help_center_screen")
    object LogoutPage : ShopCommercePage("logout_screen")
    // Feature Page
    object FeaturePage : ShopCommercePage("feature_screen")

    object FeaturePage2 : ShopCommercePage("feature_screen_2")
    object FeaturePage3 : ShopCommercePage("feature_screen_3")
    object FeaturePage4 : ShopCommercePage("feature_screen_4")
    //Taylor&Laundry
    object TaylorPage : ShopCommercePage("taylor_screen")
    object LaundryPage : ShopCommercePage("laundry_screen")
    object TaylorDetailPage : ShopCommercePage("detail_taylor")
    object LaundryDetailPage : ShopCommercePage("detail_laundry")
//    object FeaturePage4 : ShopCommercePage("feature_screen_4")
}
