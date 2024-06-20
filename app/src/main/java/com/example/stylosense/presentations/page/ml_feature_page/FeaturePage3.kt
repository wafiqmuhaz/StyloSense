package com.example.stylosense.presentations.page.ml_feature_page

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

data class ApiResponse(
    @SerializedName("bucket links") val bucketLinks: List<String>,
    @SerializedName("color recommendation") val colorRecommendation: String,
    @SerializedName("hex codes") val hexCodes: List<String>,
    val prediction: String
)

interface ApiService {
    @Multipart
    @POST("predict?file")
    suspend fun uploadImage(@Part file: MultipartBody.Part): ApiResponse
}

object ApiClient {
    private const val BASE_URL = "https://stylosense-ml-service-kaya6rctvq-et.a.run.app/"

    private val client = OkHttpClient.Builder().build()

    val apiService: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var apiResponse by mutableStateOf<ApiResponse?>(null)

    fun uploadImage(uri: Uri, navController: NavHostController) {
        viewModelScope.launch {
            try {
                val file = createTempFileFromUri(uri, getApplication<Application>().applicationContext)
                val requestBody = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
                val multipartBody = MultipartBody.Part.createFormData("file", file.name, requestBody)

                val response = ApiClient.apiService.uploadImage(multipartBody)
                println("Raw API Response: $response")  // Debugging line to print raw response

                if (response.bucketLinks != null && response.colorRecommendation != null && response.hexCodes != null) {
                    apiResponse = response
                    navController.navigate("result_page")
                } else {
                    // Handle null values or partial data here
                    println("Incomplete data received: $response")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

class MainViewModelFactory(
    private val application: Application
) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Composable
fun FeaturePage3(navController: NavHostController, viewModel: MainViewModel) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                selectedImageUri?.let { uri ->
                    Image(
                        painter = rememberAsyncImagePainter(uri),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    imagePickerLauncher.launch("image/*")
                }) {
                    Text("Pilih Gambar")
                }
                Spacer(modifier = Modifier.height(16.dp))
                selectedImageUri?.let { uri ->
                    Button(onClick = {
                        viewModel.uploadImage(uri, navController)
                        navController.navigate(ShopCommercePage.FeaturePage4.route)
                    }) {
                        Text("Unggah dan Prediksi")
                    }
                }
            }
        }
    }
}
fun createTempFileFromUri(uri: Uri, context: Context): File {
    val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
    val tempFile = File(context.cacheDir, "temp_image.jpg")
    inputStream.use { input ->
        FileOutputStream(tempFile).use { output ->
            input?.copyTo(output)
        }
    }
    return tempFile
}

//@Composable
//fun FeaturePage3(navController: NavHostController) {
//    val lensFacing = CameraSelector.LENS_FACING_BACK
//    val lifecycleOwner = LocalLifecycleOwner.current
//    val context = LocalContext.current
////    val preview = Preview.Builder().build() //Builder().build()
//    val previewView = remember {
//        PreviewView(context)
//    }
//    val cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
//    val imageCapture = remember {
//        ImageCapture.Builder().build()
//    }
//    LaunchedEffect(lensFacing) {
//        val cameraProvider = context.getCameraProvider()
//        cameraProvider.unbindAll()
//        cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector,
////            preview,
//            imageCapture)
////        preview.setSurfaceProvider(previewView.surfaceProvider)
//    }
//    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
//        AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
//        Button(onClick = { captureImage(imageCapture, context) }) {
//            Text(text = "Capture Image")
//        }
//    }
//}
//
//private fun captureImage(imageCapture: ImageCapture, context: Context) {
//    val name = "CameraxImage.jpeg"
//    val contentValues = ContentValues().apply {
//        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
//            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
//        }
//    }
//    val outputOptions = ImageCapture.OutputFileOptions
//        .Builder(
//            context.contentResolver,
//            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//            contentValues
//        )
//        .build()
//    imageCapture.takePicture(
//        outputOptions,
//        ContextCompat.getMainExecutor(context),
//        object : ImageCapture.OnImageSavedCallback {
//            override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
//                println("Successs")
//            }
//
//            override fun onError(exception: ImageCaptureException) {
//                println("Failed $exception")
//            }
//
//        })
//}
//
//private suspend fun Context.getCameraProvider(): ProcessCameraProvider =
//    suspendCoroutine { continuation ->
//        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
//            cameraProvider.addListener({
//                continuation.resume(cameraProvider.get())
//            }, ContextCompat.getMainExecutor(this))
//        }
//    }