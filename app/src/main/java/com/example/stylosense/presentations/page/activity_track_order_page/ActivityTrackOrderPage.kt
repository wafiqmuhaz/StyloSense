package com.example.stylosense.presentations.page.activity_track_order_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.stylosense.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackOrdersPage() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Track Orders") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.tailorworking),
                    contentDescription = "Tailor working",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TrackStatus(
                    steps = listOf(
                        TrackStep("Pick up", true),
                        TrackStep("On progress", false),
                        TrackStep("Delivery", true),
                        TrackStep("Finished", true)
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                SummaryList(
                    items = listOf(
                        SummaryListItem("Vermak", "Rp25.000"),
                        SummaryListItem("Platform fee", "Rp1.500"),
                        SummaryListItem("Delivery fee", "Rp10.000"),
                        SummaryListItem("Total", "Rp36.500")
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                SummaryListItem("Paid with BCA Mobile", "Rp36.500")
                Spacer(modifier = Modifier.height(16.dp))
                PaymentStatus(
                    items = listOf(
                        PaymentStatusItem(true, "Penjemputan"),
                        PaymentStatusItem(false, "Proses Pengerjaan")
                    )
                )
            }
        }
    )
}

@Composable
fun TrackStatus(steps: List<TrackStep>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        steps.forEach { step ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (step.completed) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Completed",
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.watch),
                        contentDescription = "In progress",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = step.label)
            }
            if (step != steps.last()) {
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )
            }
        }
    }
}

data class TrackStep(val label: String, val completed: Boolean)

@Composable
fun SummaryList(items: List<SummaryListItem>) {
    Column {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.label)
                Text(text = item.value)
            }
        }
    }
}

data class SummaryListItem(val label: String, val value: String)

@Composable
fun PaymentStatus(items: List<PaymentStatusItem>) {
    Column {
        items.forEach { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (item.completed) {
                    Icon(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = "Completed",
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.watch),
                        contentDescription = "In progress",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = item.label)
            }
        }
    }
}

data class PaymentStatusItem(val completed: Boolean, val label: String)