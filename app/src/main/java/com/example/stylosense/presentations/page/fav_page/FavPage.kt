package com.example.stylosense.presentations.page.fav_page

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import coil.compose.rememberImagePainter
import com.example.stylosense.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

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
                .height(650.dp)
        ) {
            items(tailors.value) { tailor ->
//                TailorItem(tailor = tailor)
                TailorItem(tailor = tailor, navController = navController)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TailorItem(tailor: Tailor, navController: NavHostController) {
    Card (
        colors = CardDefaults.cardColors(
            Color.Gray
        ),
        onClick = {
            navController.navigate("order_detail/${tailor.id}") // Navigate to DetailTaylor
        }
    ){
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