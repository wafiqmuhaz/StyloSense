package com.example.stylosense.presentations.graph.auth_graph

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.page.splash_page.SplashPage


fun NavGraphBuilder.authNavigationGraph(navController: NavHostController, context: Context) {
    navigation(
        route = Graph.AUTHENTICATION_GRAPH,
        startDestination = AuthPage.OnBoardingPage.route
    ) {
        composable(AuthPage.OnBoardingPage.route) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                (context as Activity).window.decorView.windowInsetsController?.hide(
                    WindowInsets.Type.statusBars()
                );
            } else {
                (context as Activity).window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
            SplashPage(navController)

            Log.d("Navigation Call", "Called Splash Screen")
        }
        composable(AuthPage.SignInPage.route) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                (context as Activity).window.decorView.windowInsetsController?.show(
                    WindowInsets.Type.statusBars()
                );
            } else {
                (context as Activity).window.apply {
                    clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                    clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                }

            }
//            LoginScreen(navController = navController)
        }
//        composable(AuthPage.ForgetPasswordScreen.route) {
//            ForgetPasswordScreen(navController = navController)
//        }
//        composable(AuthPage.OTPScreen.route) {
//            OTPScreen(navController = navController)
//        }
//        composable(AuthPage.SignUpScreen.route) {
//            SignUpScreen(navController = navController)
//        }
//        composable(AuthPage.SignInSuccess.route) {
//            SignInScreen(navController = navController)
//        }

    }
}