package com.example.stylosense.presentations.page.detail_chat_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatDetailPage() {
    var messageText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_profile),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Penjahit A",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
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
            ChatInputBar(messageText, onMessageChange = { messageText = it }, onSendClick = {
                // Send message logic here
                messageText = ""
            })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Display chat messages (consider using a LazyColumn here)
            // ...
        }
    }
}

@Composable
fun ChatInputBar(messageText: String, onMessageChange: (String) -> Unit, onSendClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onSendClick,
            modifier = Modifier
                .size(25.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "Send",
                tint = Color.White
            )
        }
        OutlinedTextField(
            value = messageText,
            onValueChange = onMessageChange,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
                .padding(start = 16.dp),
            placeholder = { Text("Type a message...") },
//            colors = OutlinedTextFieldDefaults.textFieldColors(
//                containerColor = Color.White,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent
//            )
        )
        IconButton(
            onClick = onSendClick,
            modifier = Modifier
                .size(25.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_send),
                contentDescription = "Send",
                tint = Color.White
            )
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
            text = { Text("Chats", color = Color.White) },
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