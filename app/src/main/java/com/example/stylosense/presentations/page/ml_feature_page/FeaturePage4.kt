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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.stylosense.R

@Composable
fun FeaturePage4(viewModel: MainViewModel) {
    val response = viewModel.apiResponse

    println("Responses Api: $response")
    if (response != null) {
        println("Responses prediction Api: ${response.prediction}")
    }

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                response?.let {
                    Text("Prediction: ${it.prediction ?: "N/A"}", fontSize = 20.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))
                    it.bucketLinks?.forEach { link ->
                        Image(
                            painter = rememberAsyncImagePainter(link),
                            contentDescription = "file",
                            modifier = Modifier.size(100.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Color Recommendations: ${it.colorRecommendation ?: "N/A"}", fontSize = 16.sp, color = Color.Black)
                }
            }
        }
    }
}
