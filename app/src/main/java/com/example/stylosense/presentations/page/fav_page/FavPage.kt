package com.example.stylosense.presentations.page.fav_page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.auth_graph.AuthPage
import com.example.stylosense.presentations.page.splash_page.Purple
import com.example.stylosense.presentations.page.tailor_list_page.Tailor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FavouritePage(navController: NavHostController) {
    val tailors = remember { mutableStateOf<List<Tailor>>(emptyList()) }

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = fetchTailorsFromApi()
            val data = parseJson(response)
            withContext(Dispatchers.Main) {
                tailors.value = data
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(22.dp)
                .height(700.dp)
        ) {
            items(tailors.value.take(3)) { tailor ->
                TailorItem(tailor = tailor, navController = navController)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TailorItem(tailor: Tailor, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("order_detail/${tailor.id}") },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
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
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier) { // Remove weight
                    Text(
                        text = tailor.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontSize = 25.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Row {
                        Icons.Default.Info
                        Text(
                            text = "Ongoing",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }
                Button(
                onClick = { navController.navigate("order_detail/${tailor.id}") },
                modifier = Modifier
                .padding(vertical = 2.dp)
                .width(90.dp)
                .height(40.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Purple)
                ) {
                    Text(
                        text = "Track",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.muli_bold))
                    )
                }
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

suspend fun fetchTailorsFromApi(): String {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://stylosense-backend-service-kaya6rctvq-et.a.run.app/api/v1/tailors")
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

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun getTailorById(id: Int): Tailor? {
    val tailors = remember { mutableStateOf<List<Tailor>>(emptyList()) }

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = fetchTailorsFromApi()
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