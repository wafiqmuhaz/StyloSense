package com.example.stylosense.presentations.page.ml_feature_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
        println("Responses hexCodes Api: ${response.hexCodes}")
        println("Responses bucketLinks Api: ${response.bucketLinks}")
        println("Responses colorRecommendation Api: ${response.colorRecommendation}")
    }

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(22.dp))
                Text(
                    text = "Here’s your results",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(22.dp))

                response?.let {

//                    Card (
//                        colors = CardDefaults.cardColors(
//                            Color(android.graphics.Color.parseColor("#D1D0D0"))
//                        )
//                    ) {
//                        Spacer(modifier = Modifier.height(16.dp))
//                        ColorRow(it.bucketLinks, it.hexCodes)
//                        Spacer(modifier = Modifier.height(16.dp))
//                        ColorRow2(it.bucketLinks, it.hexCodes)
//                        Spacer(modifier = Modifier.height(16.dp))
//                    }
                    Card (
                        colors = CardDefaults.cardColors(
                            Color(android.graphics.Color.parseColor("#D1D0D0"))
                        ),
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Spacer(modifier = Modifier.height(16.dp))
                                ColorRow(it.bucketLinks, it.hexCodes)
                                Spacer(modifier = Modifier.height(16.dp))
                                ColorRow2(it.bucketLinks, it.hexCodes)
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "These clothes should fit you best",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Left,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    response?.let {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(it.bucketLinks.size) { index ->
                                val link = it.bucketLinks[index]
                                val hexCodeGray = "#e4e4e4"
                                val colorCode = Color(android.graphics.Color.parseColor(hexCodeGray))
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .height(300.dp)
                                        .width(350.dp)
                                        .clip(RoundedCornerShape(22.dp))
                                        .background(colorCode)
                                        .padding(16.dp)
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        Image(
                                            painter = rememberAsyncImagePainter(link),
                                            contentDescription = "file",
                                            modifier = Modifier
                                                .height(295.dp)
                                                .width(345.dp),
                                            contentScale = ContentScale.FillHeight
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorRow(bucketLinks: List<String>, hexCodes: List<String>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(bucketLinks.size) { index ->
            if (index == 0 || index == 1 || index == 2) { // Check for index 3 (item 4) and index 4 (item 5)
                val hexCode = hexCodes.getOrNull(index) ?: "#000000" // Default to black if hexCode is missing
                val colorCode = Color(android.graphics.Color.parseColor(hexCode))

                Card (
                    colors = CardDefaults.cardColors(
                        Color(android.graphics.Color.parseColor("#ECECEC"))
                    )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(colorCode)
                                .padding(16.dp) // padding agar teks tidak menempel ke tepi
                        ) {
                            // Jika ada konten di dalam Box, letakkan di sini
                        }
                        Spacer(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = hexCode,
                            color = Color.Black, // Sesuaikan warna teks agar terlihat dengan latar belakang
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ColorRow2(bucketLinks: List<String>, hexCodes: List<String>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(bucketLinks.size) { index ->
            if (index == 3 || index == 4) { // Check for index 3 (item 4) and index 4 (item 5)
                val hexCode = hexCodes.getOrNull(index) ?: "#000000" // Default to black if hexCode is missing
                val colorCode = Color(android.graphics.Color.parseColor(hexCode))

                Card (
                    colors = CardDefaults.cardColors(
                        Color(android.graphics.Color.parseColor("#ECECEC"))
                    )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(colorCode)
                                .padding(16.dp) // padding agar teks tidak menempel ke tepi
                        ) {
                            // Jika ada konten di dalam Box, letakkan di sini
                        }
                        Spacer(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = hexCode,
                            color = Color.Black, // Sesuaikan warna teks agar terlihat dengan latar belakang
                            style = MaterialTheme.typography.titleMedium,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(
                            modifier = Modifier
                                .height(12.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}