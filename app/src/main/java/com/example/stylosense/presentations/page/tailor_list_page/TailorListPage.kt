package com.example.stylosense.presentations.page.tailor_list_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylosense.R

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TailorListPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tailors") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_backward),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LocationCard()
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(tailorsData) { tailor ->
                    TailorItem(tailor)
                }
            }
        }
    }
}

@Composable
fun LocationCard() {
    fun String.toColor() = Color(android.graphics.Color.parseColor(this))
    val orange = "F06400".toColor()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pinpoint_location),
                contentDescription = "Location",
                tint = orange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "My Location\nPark Hyatt, Jakarta Pusat",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.dropdown),
                contentDescription = "Dropdown",
                tint = Color.White
            )
        }
    }
}

@Composable
fun TailorItem(tailor: Tailor) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = tailor.imageResourceId),
                contentDescription = "Tailor Image",
                modifier = Modifier.fillMaxSize()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tailor.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tailor.services,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End
            ) {
//                RatingChip(rating = tailor.rating)
            }
        }
    }
}
@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFF6200EE)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    tint = Color.White
                )
            },
            text = { Text("Home", color = Color.White) },
            selected = false,
            onClick = { /* Handle home click */ }
        )
        BottomNavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_activity),
                    contentDescription = "Activity",
                    tint = Color.White
                )
            },
            text = { Text("Activity", color = Color.White) },
            selected = false,
            onClick = { /* Handle activity click */ }
        )
        BottomNavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_feature),
                    contentDescription = "Feature",
                    tint = Color.White
                )
            },
            text = { Text("Feature", color = Color.White) },
            selected = false,
            onClick = { /* Handle feature click */ }
        )
        BottomNavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.chat_bubble_icon),
                    contentDescription = "Chats",
                    tint = Color.White
                )
            },
            text = { Text("Chats", color = Color.White) },
            selected = false,
            onClick = { /* Handle chats click */ }
        )
        BottomNavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile_gray),
                    contentDescription = "Profile",
                    tint = Color.White
                )
            },
            text = { Text("Profile", color = Color.White) },
            selected = false,
            onClick = { /* Handle profile click */ }
        )
    }
}

@Composable
fun BottomNavigationBarItem(
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        icon()
        Spacer(modifier = Modifier.height(4.dp))
    }
}

data class Tailor(
    val name: String,
    val services: String,
    val rating: Float,
    val imageResourceId: Int
)

val tailorsData = listOf(
    Tailor(
        name = "Penjahit A, Manggarai",
        services = "vermak, jahit, gorden",
        rating = 4.7f,
        imageResourceId = R.drawable.tailorfoto
    ),
    Tailor(
        name = "Penjahit A, Manggarai",
        services = "Vermak, Jahit, Gorden",
        rating = 4.7f,
        imageResourceId = R.drawable.tailorfoto
    ),
    Tailor(
        name = "Penjahit A, Manggarai",
        services = "Vermak, Jahit, Gorden",
        rating = 4.7f,
        imageResourceId = R.drawable.tailorfoto
    )
)
