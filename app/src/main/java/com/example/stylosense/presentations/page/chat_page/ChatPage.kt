package com.example.stylosense.presentations.screen.chat_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylosense.R
import com.example.stylosense.presentations.page.splash_page.Purple

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatPage() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chat", color = Color.Black) },
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
            Text(
                text = "Your Chats",
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(chatData) { chat ->
                    ChatItem(chat)
                }
            }
        }
    }
}

@Composable
fun ChatItem(chat: Chat) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { /* Handle chat item click */ },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = chat.profileImage),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = chat.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = chat.message,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = chat.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                if (chat.hasNewMessage) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color.Red),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(painter = painterResource(id = R.drawable.reddot), contentDescription = null)
                    }
                }
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
                    painter = painterResource(id = R.drawable.ic_chats),
                    contentDescription = "Chats",
                    tint = Color.White
                )
            },
            text = { Text("Chats", color = Purple) },
            selected = true,
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
//        Text(text = text, color = if (selected) Color.White else Color.Gray)
    }
}

data class Chat(
    val name: String,
    val message: String,
    val date: String,
    val profileImage: Int,
    val hasNewMessage: Boolean
)

val chatData = listOf(
    Chat(
        name = "Penjahit A",
        message = "you have a new message",
        date = "02/04/2024",
        profileImage = R.drawable.img_profile,
        hasNewMessage = true
    ),
    Chat(
        name = "Penjahit A",
        message = "you have a new message",
        date = "02/04/2024",
        profileImage = R.drawable.img_profile,
        hasNewMessage = true
    ),
    Chat(
        name = "Penjahit A",
        message = "you have a new message",
        date = "02/04/2024",
        profileImage = R.drawable.img_profile,
        hasNewMessage = true
    )
)