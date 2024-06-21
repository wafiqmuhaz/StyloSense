package com.example.stylosense.presentations.page.track_order_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.auth_graph.AuthPage
import com.example.stylosense.presentations.page.splash_page.Purple
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackOrderPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        // Back Button
        Spacer(modifier = Modifier.height(20.dp))

        // Title
        Text(
            textAlign = TextAlign.Left,
            text = "Track Orders",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Order Image
        Image(
            painter = painterResource(id = R.drawable.image_banner_3),
            contentDescription = "Order Progress",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Order Status
        OrderStatusRow(
            status = "Pick up",
            completed = true,
            icon = Icons.Default.CheckCircle,
            iconColor = Color(0xFF00AA13)
        )
        OrderStatusRow(
            status = "On progress",
            completed = false,
            icon = Icons.Default.Info, //HourglassEmpty
            iconColor = Color(0xFFF06400)
        )
        OrderStatusRow(
            status = "Delivery",
            completed = true,
            icon = Icons.Default.CheckCircle,
            iconColor = Color(0xFF484848)
        )
        OrderStatusRow(
            status = "Finished",
            completed = true,
            icon = Icons.Default.CheckCircle,
            iconColor = Color(0xFF484848)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Order Details
        OrderSummaryItem(
            itemName = "Vermak",
            itemPrice = "Rp25.000"
        )
        OrderSummaryItem(
            itemName = "Platform fee",
            itemPrice = "Rp1.500"
        )
        OrderSummaryItem(
            itemName = "Delivery fee",
            itemPrice = "Rp10.000"
        )
        Divider()
        OrderSummaryItem(
            itemName = "Total",
            itemPrice = "Rp36.500",
            isBold = true
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Payment Method
        Text(
            text = "Paid with BCA Mobile",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Current Status
        OrderStatusRow(
            status = "Penjemputan",
            completed = true,
            icon = Icons.Default.CheckCircle,
            iconColor = Color(0xFF00AA13)
        )
        OrderStatusRow(
            status = "Proses Pengerjaan",
            completed = false,
            icon = Icons.Default.Info, //HourglassEmpty
            iconColor = Color(0xFFF06400)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Additional Space
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun OrderStatusRow(
    status: String,
    completed: Boolean,
    icon: ImageVector,
    iconColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = "Status Icon",
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = status,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Divider(
            modifier = Modifier.width(1.dp),
            color = Color.Gray
        )
    }
}

@Composable
fun OrderSummaryItem(
    itemName: String,
    itemPrice: String,
    isBold: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = itemName,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            text = itemPrice,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )
    }
}