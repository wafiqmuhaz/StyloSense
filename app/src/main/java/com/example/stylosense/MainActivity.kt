package com.example.stylosense

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.stylosense.presentations.graph.root_graph.RootNavigationGraph
import com.example.stylosense.ui.theme.StyloSenseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StyloSenseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowScreen(LocalContext.current)
                }
            }
        }
    }
    private fun setCameraPreview() {
        setContent {
            StyloSenseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val NavHostController = rememberNavController()
                }
            }
        }
    }
}

@Composable
private fun ShowScreen(context: Context) {
    val navHostController = rememberNavController()
    RootNavigationGraph(navHostController = navHostController, context = context)
}

