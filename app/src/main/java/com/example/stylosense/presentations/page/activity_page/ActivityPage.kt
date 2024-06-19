package com.example.stylosense.presentations.screen.activity_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stylosense.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityScreen() {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = false,
                    onClick = { /* Handle Home click */ }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(id = R.drawable.ic_activity), contentDescription = "Activity") },
                    label = { Text("Activity") },
                    selected = true,
                    onClick = { /* Handle Activity click */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "Feature") },
                    label = { Text("Feature") },
                    selected = false,
                    onClick = { /* Handle Feature click */ }
                )
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(id = R.drawable.ic_chats), contentDescription = "Chats") },
                    label = { Text("Chats") },
                    selected = false,
                    onClick = { /* Handle Chats click */ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { /* Handle Profile click */ }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Activity",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            ActivitySection(
                title = "Ongoing",
                items = listOf(
                    ActivityItem(
                        imageVector = ImageVector.vectorResource(id = R.drawable.img_profile),
                        title = "Penjahit A",
                        status = "Ongoing",
                        date = "02/04/2024",
                        actionLabel = "Track"
                    ),
                    ActivityItem(
                        imageVector = ImageVector.vectorResource(id = R.drawable.img_profile),
                        title = "Penjahit B",
                        status = "Ongoing",
                        date = "02/04/2024",
                        actionLabel = "Track"
                    )
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            ActivitySection(
                title = "History",
                items = listOf(
                    ActivityItem(
                        imageVector = ImageVector.vectorResource(id = R.drawable.img_profile),
                        title = "Penjahit A",
                        status = "Order Completed",
                        date = "02/04/2024",
                        actionLabel = "Details"
                    ),
                    ActivityItem(
                        imageVector = ImageVector.vectorResource(id = R.drawable.img_profile),
                        title = "Penjahit B",
                        status = "Order Completed",
                        date = "02/04/2024",
                        actionLabel = "Details"
                    )
                )
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActivitySection(title: String, items: List<ActivityItem>) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(items) { item ->
                ActivityItemCard(item)
            }
        }
    }
}

@Composable
fun ActivityItemCard(item: ActivityItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.imageVector,
                    contentDescription = "Tailor",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = item.status,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Column {
                Text(
                    text = item.date,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = { /* Handle action click */ },
                    modifier = Modifier.width(80.dp)
                ) {
                    Text(item.actionLabel)
                }
            }
        }
    }
}

data class ActivityItem(
    val imageVector: ImageVector,
    val title: String,
    val status: String,
    val date: String,
    val actionLabel: String
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ActivityScreen()
}