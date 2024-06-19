package com.example.stylosense.presentations.page.add_order_page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderPage() {
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var selectedFabricType by remember { mutableStateOf("") }
    var selectedFabricSize by remember { mutableStateOf("") }
    var selectedDelivery by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Add Order") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Location Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = androidx.compose.material.icons.Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "My Location",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Park Hyatt, Jakarta Pusat",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    IconButton(onClick = { /* Handle location change */ }) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Filled.ArrowDropDown,
                            contentDescription = "Dropdown",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            // Name and Phone Input
            Column(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Full name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    label = { Text("Phone Number") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Fabric Type
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Fabric Type",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { selectedFabricType = "atas" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Atasan")
                    }
                    Button(
                        onClick = { selectedFabricType = "bawahan" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Bawahan")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { selectedFabricType = "terusan" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Terusan")
                    }
                    Button(
                        onClick = { selectedFabricType = "gorden" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Gorden")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { selectedFabricType = "jas" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Jas")
                    }
                    Button(
                        onClick = { selectedFabricType = "luaran" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Luaran")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { selectedFabricType = "jeans" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Jeans")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }

            // Fabric Size
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Fabric Size",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { selectedFabricSize = "small (1m)" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Small (1m)")
                    }
                    Button(
                        onClick = { selectedFabricSize = "medium (5m)" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Medium (5m)")
                    }
                    Button(
                        onClick = { selectedFabricSize = "large (10m)" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Large (10m)")
                    }
                }
            }

            // Self Pickup/Delivery
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Self Pickup/Delivery",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { selectedDelivery = "Self Pickup" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Self Pickup")
                    }
                    Button(
                        onClick = { selectedDelivery = "Delivery" },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Delivery")
                    }
                }
            }

            // Description
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )

            // Photo
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Photo (max 10mb)",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Handle photo upload */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Upload")
                }
            }

            // Buttons
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Handle order confirmation */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Pesan Langsung")
                }
                Button(
                    onClick = { /* Handle add to cart */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Add to Cart")
                }
            }
        }
    }
}
