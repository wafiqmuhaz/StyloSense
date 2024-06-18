package com.example.stylosense.presentations.graph.root_graph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.graph.auth_graph.authNavGraph
import com.example.stylosense.presentations.page.home_page.HomeScreen

@Composable
fun RootNavGraph(navHostController: NavHostController, context: Context) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT_GRAPH,
        startDestination = Graph.AUTHENTICATION_GRAPH,
    ) {
        authNavGraph(navHostController, context)
        composable(route = Graph.HOME_GRAPH) {
            HomeScreen()
        }
    }
}