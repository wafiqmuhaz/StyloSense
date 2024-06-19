package com.example.stylosense.presentations.graph.auth_graph

sealed class AuthPage(val route: String) {
    object OnBoardingPage : AuthPage("splash_screen")
    object SignInPage : AuthPage("sign_in_screen")
    object SignUpPage : AuthPage("sign_up_screen")
    object SignInSuccessPage : AuthPage("sign_success")
}