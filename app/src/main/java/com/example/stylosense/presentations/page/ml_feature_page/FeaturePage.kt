package com.example.stylosense.presentations.page.ml_feature_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeaturePage(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Feature", color = Color.Black) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
//        bottomBar = {
//            BottomNavigationBar()
//        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to Our Feature!",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Let us help you find your colors based on your skin tone.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Indicators (You can customize the color and style)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(colorScheme.primary)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
//                        .shape(RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(colorScheme.secondary)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
//                        .shape(RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Color.Gray)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
//                        .shape(RoundedCornerShape(50))
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate(ShopCommercePage.FeaturePage2.route)
                          },
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE),
                    contentColor = Color.White
                )
            ) {
                Text("Next", style = MaterialTheme.typography.labelLarge)
            }
        }
    }
}

//@Composable
//fun BottomNavigationBar() {
//    NavigationBar {
//        NavigationBarItem(
//            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
//            label = { Text("Home") },
//            selected = false,
//            onClick = { /* Handle Home click */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(Icons.Filled.List, contentDescription = "Activity") },
//            label = { Text("Activity") },
//            selected = false,
//            onClick = { /* Handle Activity click */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(Icons.Filled.Star, contentDescription = "Feature") },
//            label = { Text("Feature") },
//            selected = true,
//            onClick = { /* Handle Feature click */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(Icons.Filled.Chat, contentDescription = "Chats") },
//            label = { Text("Chats") },
//            selected = false,
//            onClick = { /* Handle Chats click */ }
//        )
//        NavigationBarItem(
//            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
//            label = { Text("Profile") },
//            selected = false,
//            onClick = { /* Handle Profile click */ }
//        )
//    }
//}

////////

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    FeatureScreen(
//        navController = NavHostController()
//    )
//}