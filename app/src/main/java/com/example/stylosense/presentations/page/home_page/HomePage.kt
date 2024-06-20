package com.example.stylosense.presentations.page.home_page

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stylosense.presentations.graph.home_graph.HomeNavigationGraph
import com.example.stylosense.presentations.page.ml_feature_page.MainViewModel
import com.example.stylosense.presentations.widgets.AppBarWidget
import com.example.stylosense.presentations.widgets.NavBarWidgets


@SuppressLint("RememberReturnType")
@Composable
fun HomePage(
    navController: NavHostController = rememberNavController(),
//    scaffoldState: ScaffoldState = rememberScaffoldState(),
    mainViewModel: MainViewModel,
    boxScrollState: ScrollState = rememberScrollState(),
) {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    //topBar visibility state
    val topBarVisibilityState = remember {
        mutableStateOf(true)
    }


    Scaffold(
//        scaffoldState = scaffoldState,
//        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
//        topBar = {
//            AppBarWidget(
//                navController = navController,
//                isVisible = topBarVisibilityState.value,
//                searchCharSequence = {
//
//                },
//                onCartIconClick = {
////                    navController.navigate(DetailPage.CartScreen.route)
//                },
//                onNotificationIconClick = {
////                    navController.navigate(DetailPage.NotificationScreen.route)
//                }
//            )
//        },
        bottomBar = {
            NavBarWidgets(navController = navController) { isVisible ->
                topBarVisibilityState.value = isVisible
            }
        }

    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(boxScrollState)
        ) {
            HomeNavigationGraph(viewModel = mainViewModel, navHostController = navController)
        }
    }
}


