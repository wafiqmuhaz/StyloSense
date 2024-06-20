package com.example.stylosense.presentations.page.detail_taylor_page.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTaylorPage(navController: NavHostController, backStackEntry: NavBackStackEntry) {
    val tailorId = backStackEntry.arguments?.getString("tailorId")?.toIntOrNull() ?: 0
    val tailors = remember { mutableStateOf<List<Tailor>>(emptyList()) }
    fun String.toColor() = Color(android.graphics.Color.parseColor(this))
    val orange = "#F06400".toColor()


    // Fetch data from the API using the tailorId
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = fetchTailorsFromApi(tailorId) // Pass tailorId to function
            val data = parseJson(response)
            withContext(Dispatchers.Main) {
                tailors.value = data
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Penjahit ${tailors.value.firstOrNull()?.name ?: ""}") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(22.dp) // Adjusted padding
                    .height(650.dp)
            ) {
                items(tailors.value) { tailor ->
                    // Tailor Item (Image)
                    Column(modifier = Modifier.padding(bottom = 16.dp)) {
                        Image(
                            painter = rememberImagePainter(
                                data = tailor.imageUrl,
                                builder = { crossfade(true) }
                            ),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        // Tailor Details
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "${tailor.name}, ${tailor.location}",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = tailor.description,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null,
                                tint = Color(0xFFFDCF0C)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = tailor.reviews.toString(),
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.weight(1f)) // Push items to the left
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Location",
                                tint = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "0.81 km",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.Gray
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.CheckCircle,
                                contentDescription = "Delivery",
                                tint = if (tailor.delivery == 1) Color.Green else Color.Red
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (tailor.delivery == 1) "Dropoff Delivery" else "No Delivery",
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (tailor.delivery == 1) Color.Green else Color.Red
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),// Adjust elevation as needed
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF673AB7) // Purple card background
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                        ) {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "My Location",
                                tint = orange
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "My Location",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.White
                                )
                                Text(
                                    text = "Park Hyatt, Jakarta Pusat",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                imageVector = Icons.Filled.ArrowDropDown,
                                contentDescription = "Dropdown",
                                tint = Color.White
                            )
                        }
                    }
                    // Service Buttons
                    Spacer(modifier = Modifier.height(16.dp)) // Add spacing between My Location Card and buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // First Service
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(170.dp) // Adjust height as needed
                                .padding(8.dp) // Add padding to the Card itself
                                .clickable {
                                    navController.navigate("summary/${tailor.id}")
                                }
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
//                                modifier = Modifier.padding(16.dp) // Padding for text inside the Card
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = "Tambal Baju",
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        // Second Service
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(170.dp) // Adjust height as needed
                                .padding(8.dp) // Add padding to the Card itself
                                .clickable {
                                    navController.navigate("summary/${tailor.id}")
                                }
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
//                                modifier = Modifier.padding(16.dp) // Padding for text inside the Card
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = "Vermak",
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    // Second Row of Services
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Third Service
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(170.dp) // Adjust height as needed
                                .padding(8.dp) // Add padding to the Card itself
                                .clickable {
                                    navController.navigate("summary/${tailor.id}")
                                }
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
//                                modifier = Modifier.padding(16.dp) // Padding for text inside the Card
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = "Tambah Material",
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        // Fourth Service
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(170.dp) // Adjust height as needed
                                .padding(8.dp) // Add padding to the Card itself
                                .clickable {
                                    navController.navigate("summary/${tailor.id}")
                                }
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
//                                modifier = Modifier.padding(16.dp) // Padding for text inside the Card
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(
                                    text = "Modifikasi",
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            // Floating Action Button (My Location)
            FloatingActionButton(onClick = { /* Handle My Location Click */ }) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "My Location"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TailorItem(tailor: Tailor, navController: NavHostController) {
    Card(
        colors = CardDefaults.cardColors(
            Color.Gray
        ),
        onClick = {
            navController.navigate("detail/${tailor.id}") // Navigate to DetailTaylor
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.White)
                .padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = tailor.imageUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = tailor.name,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = tailor.location,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = tailor.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Reviews: ${tailor.reviews}",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = if (tailor.delivery == 1) "Delivery available" else "No delivery available",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

data class Tailor(
    val id: Int,
    val name: String,
    val location: String,
    val description: String,
    val reviews: Double,
    val delivery: Int,
    val imageUrl: String
)

suspend fun fetchTailorsFromApi(tailorId: Int): String { // Accept tailorId
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://stylosense-backend-service-kaya6rctvq-et.a.run.app/api/v1/tailors/$tailorId") // Use the provided tailorId
        .build()
    val response = client.newCall(request).execute()
    return response.body?.string() ?: ""
}

fun parseJson(json: String): List<Tailor> {
    val tailors = mutableListOf<Tailor>()
    val jsonObject = JSONObject(json)
    val dataArray = jsonObject.getJSONArray("data")
    for (i in 0 until dataArray.length()) {
        val tailorObject = dataArray.getJSONObject(i)
        val id = tailorObject.getInt("id")
        val name = tailorObject.getString("name")
        val location = tailorObject.getString("location")
        val description = tailorObject.getString("description")
        val reviews = tailorObject.getDouble("reviews")
        val delivery = tailorObject.getInt("delivery")
        val imageUrl = tailorObject.getString("image_url")
        tailors.add(Tailor(id, name, location, description, reviews, delivery, imageUrl))
    }
    return tailors
}

//fun getTailorById(id: Int): Tailor? {
//    return tailors.value.find { it.id == id }
//}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun getTailorById(id: Int): Tailor? {
    val tailors = remember { mutableStateOf<List<Tailor>>(emptyList()) }

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = fetchTailorsFromApi(id)
            val data = parseJson(response)
            withContext(Dispatchers.Main) {
                tailors.value = data
                // Now you can find the tailor by ID
                val tailor = tailors.value.find { it.id == id }
                // ... use the tailor data ...
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    return null // For now, return null if not found
}