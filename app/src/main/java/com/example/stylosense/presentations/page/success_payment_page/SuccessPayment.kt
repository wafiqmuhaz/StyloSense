package com.example.stylosense.presentations.page.success_payment_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage
import com.example.stylosense.presentations.page.splash_page.Purple

@Composable
fun SuccessPaymentPage(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6200EE)), // Purple background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF9C27B0), CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF9C27B0), CircleShape)
            )
        }
        // Checkmark Icon
        Image(
            painter = painterResource(id = R.drawable.success), //ic_check_circle Replace with your actual resource ID
            contentDescription = "Checkmark",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        // Success Message
        Text(
            text = "Payment Successful",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        // Decorative Circles (optional)
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF9C27B0), CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF9C27B0), CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                navController.navigate(ShopCommercePage.DashboardPage.route)
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple)
        ) {
            Text(
                text = "Kembali",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.muli_bold))
            )
            Spacer(Modifier.width(25.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Next",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }
    }
}
