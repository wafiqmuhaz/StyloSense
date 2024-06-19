package com.example.stylosense.presentations.page.detail_taylor_page.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stylosense.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TailorDetailsScreen(function: () -> Boolean) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Penjahit A") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_backward),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.tailorfoto),
                contentDescription = "Tailor Image",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Penjahit A, Manggarai",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "vermak, jahit, gorden",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RatingInfo(rating = 4.7f, reviews = 5)
                DistanceInfo(distance = "0.81 km")
                DeliveryInfo(type = "Dropoff")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LocationCard()
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(serviceOptions) { option ->
                    ServiceOptionButton(option)
                }
            }
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun RatingInfo(rating: Float, reviews: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.star_icon),
            contentDescription = "Rating Star",
            tint = Color.Yellow
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = String.format("%.1f", rating),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "$reviews reviews",
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DistanceInfo(distance: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.greenlocation),
            contentDescription = "Distance Icon",
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = distance,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun DeliveryInfo(type: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.delivery),
            contentDescription = "Delivery Icon",
            tint = Color.Red
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = type,
            fontSize = 14.sp,
            color = Color.Red
        )
    }
}

@Composable
fun LocationCard() {
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
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "My Location",
                color = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Park Hyatt, Jakarta Pusat",
                color = Color.White
            )
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
fun ServiceOptionButton(option: String) {
    Button(
        onClick = { /* Handle option click */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Text(text = option)
    }
}

val serviceOptions = listOf("Tambal Baju", "Vermak", "Tambah Material", "Modifikasi")