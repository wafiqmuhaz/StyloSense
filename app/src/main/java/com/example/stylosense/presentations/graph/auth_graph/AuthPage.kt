package com.example.stylosense.presentations.graph.auth_graph

sealed class AuthPage(val route: String) {
    object OnBoardingScreen : AuthPage("splash_screen")
    object SignInScreen : AuthPage("sign_in_screen")
    object SignUpScreen : AuthPage("sign_up_screen")
    object SignInSuccess : AuthPage("sign_success")
    object ForgetPasswordScreen : AuthPage("forget_password_screen")
    object OTPScreen : AuthPage("otp_screen")
}