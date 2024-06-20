package com.example.stylosense.presentations.page.profile_page.profile_user_page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileDetailPage(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon( modifier = Modifier
                            .clickable{
                                navController.navigate(ShopCommercePage.EditProfilePage.route)
                            },
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_edit),
                            contentDescription = "Edit Profile"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_logout),
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_home),
                            contentDescription = "Home"
                        )
                    },
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_activity),
                            contentDescription = "Activity"
                        )
                    },
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Activity") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_feature),
                            contentDescription = "Feature"
                        )
                    },
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Feature") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_chats),
                            contentDescription = "Chats"
                        )
                    },
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Chats") }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_profile),
                            contentDescription = "Profile"
                        )
                    },
                    selected = true,
                    onClick = { /*TODO*/ },
                    label = { Text("Profile") }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.circle_photo),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Ivan Effendy", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "ivanefrendy888@gmail.com", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "+6281265783498", style = MaterialTheme.typography.bodyMedium)
        }
    }
}