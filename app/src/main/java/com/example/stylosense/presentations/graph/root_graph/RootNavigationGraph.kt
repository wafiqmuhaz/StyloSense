package com.example.stylosense.presentations.graph.root_graph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.graph.auth_graph.authNavigationGraph
import com.example.stylosense.presentations.page.home_page.HomePage
import com.example.stylosense.presentations.page.ml_feature_page.MainViewModel

@Composable
fun RootNavigationGraph(mainViewModels: MainViewModel, navHostController: NavHostController, context: Context) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT_GRAPH,
        startDestination = Graph.AUTHENTICATION_GRAPH,
    ) {
        authNavigationGraph(navHostController, context)
        composable(route = Graph.HOME_GRAPH) {
            HomePage(mainViewModel = mainViewModels)
        }
    }
}