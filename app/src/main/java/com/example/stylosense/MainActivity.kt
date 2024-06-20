package com.example.stylosense

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.stylosense.presentations.graph.root_graph.RootNavigationGraph
import com.example.stylosense.presentations.page.ml_feature_page.MainViewModel
import com.example.stylosense.presentations.page.ml_feature_page.MainViewModelFactory
import com.example.stylosense.ui.theme.StyloSenseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels {
            MainViewModelFactory(application)
        }
        setContent {
            StyloSenseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowScreen(mainViewModelR = viewModel, LocalContext.current)
                }
            }
        }
    }
}

@Composable
private fun ShowScreen(mainViewModelR: MainViewModel, context: Context) {
    val navHostController = rememberNavController()
    RootNavigationGraph(mainViewModels = mainViewModelR,navHostController = navHostController, context = context)
}