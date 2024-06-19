package com.example.stylosense.presentations.page.ml_feature_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stylosense.R


@Composable
fun FeaturePage4(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        // Header
        Text(
            text = "Analysis",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Here's your results",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Results Content
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                ColorResultItem("Bright Red", "#FF0000")
                ColorResultItem("Dark Brown", "#8B4513")
                ColorResultItem("Bright Golden", "#FFD700")
                ColorResultItem("Black", "#000000")
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "These clothes should fit you best:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Clothes suggestion images (replace with actual image resources)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.phone), //placeholder),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.phone), //placeholder),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.phone), //placeholder),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                }
            }
        }

        // Done Button
        Button(
            onClick = { /* Navigate back or complete action */ },
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
        ) {
            Text(text = "Done")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Navigation
//        BottomNavigationBar(navController = navController)
    }
}

@Composable
fun ColorResultItem(colorName: String, colorHex: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = colorName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = colorHex,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}