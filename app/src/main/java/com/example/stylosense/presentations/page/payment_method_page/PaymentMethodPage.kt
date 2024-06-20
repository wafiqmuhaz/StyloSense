package com.example.stylosense.presentations.page.payment_method_page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import com.example.stylosense.R
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage
import com.example.stylosense.presentations.page.splash_page.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodPage(navController: NavHostController) {
    var selectedPaymentMethod by remember { mutableStateOf("Gopay") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle Back button click */ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Payment Method",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Payment Method Options
        PaymentMethodOption(
            paymentMethod = "Gopay",
            selected = selectedPaymentMethod == "Gopay",
            onClick = { selectedPaymentMethod = "Gopay" }
        )
        PaymentMethodOption(
            paymentMethod = "BCA Virtual Account",
            selected = selectedPaymentMethod == "BCA Virtual Account",
            onClick = { selectedPaymentMethod = "BCA Virtual Account" }
        )
        PaymentMethodOption(
            paymentMethod = "Mandiri Virtual Account",
            selected = selectedPaymentMethod == "Mandiri Virtual Account",
            onClick = { selectedPaymentMethod = "Mandiri Virtual Account" }
        )

        Spacer(modifier = Modifier.weight(1f)) // Push content to the top

        // Total Payment and Pay Button
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total Payment",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Rp44.017",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate(ShopCommercePage.OTPPage.route)
                },
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple)
            ) {
                Text(
                    text = "Pay",
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
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun PaymentMethodOption(
    paymentMethod: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Use appropriate image resource based on payment method
            if (paymentMethod == "Gopay") {
                Image(
                    painter = painterResource(id = R.drawable.gopay_logo), // gopay_logo Replace with your actual resource ID
                    contentDescription = "Gopay Logo",
                    modifier = Modifier.size(40.dp)
                )
            } else if (paymentMethod == "BCA Virtual Account") {
                Image(
                    painter = painterResource(id = R.drawable.bca_logo), //bca_logo Replace with your actual resource ID
                    contentDescription = "BCA Logo",
                    modifier = Modifier.size(40.dp)
                )
            } else if (paymentMethod == "Mandiri Virtual Account") {
                Image(
                    painter = painterResource(id = R.drawable.mandiri_logo), // mandiri_logo Replace with your actual resource ID
                    contentDescription = "Mandiri Logo",
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = paymentMethod,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}