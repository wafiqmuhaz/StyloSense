package com.example.stylosense.presentations.page.otp_page

//
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage
import com.example.stylosense.presentations.page.splash_page.Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPPage(navController: NavHostController) {
    var otpInput by remember { mutableStateOf("") }
    val otpCode = remember { mutableStateListOf("", "", "", "") }

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
                text = "OTP Verification",
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Profile Image Placeholder
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            // You can replace this with a real profile image later
            // Image(painter = painterResource(id = R.drawable.profile_image), contentDescription = "Profile Image")
        }
        Spacer(modifier = Modifier.height(20.dp))

        // Title
        Text(
            text = "Enter Verification Code",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Description
        Text(
            text = "We have sent you one-time verification code your mobile phone number +62 82274098234",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(20.dp))

        // OTP Input Fields
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        ) {
            otpCode.forEachIndexed { index, code ->
                OutlinedTextField(
                    value = code,
                    onValueChange = {
                        if (it.length <= 1) {
                            otpCode[index] = it
                            if (index < otpCode.size - 1 && it.isNotEmpty()) {
                                otpCode[index + 1] = "" // Move to the next field if current field is not empty
                            }
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = CircleShape,
                    label = { Text("") }
                )
                if (index < otpCode.size - 1) {
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        //
        Button(
            onClick = {
                navController.navigate(ShopCommercePage.SuccessPaymentPage.route)
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple)
        ) {
            Text(
                text = "Verify",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.muli_bold))
            )
            Spacer(Modifier.width(25.dp))
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Lock Icon",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }
        // Verify Button
        Spacer(modifier = Modifier.height(30.dp))
    }
}
