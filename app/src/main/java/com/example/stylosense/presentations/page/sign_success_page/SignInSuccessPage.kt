package com.example.stylosense.presentations.page.sign_success_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.Graph
import com.example.stylosense.presentations.widgets.BtnWidget


@Composable
fun SignInSuccessPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Login Success",
                color = Color.Black,
                fontWeight = FontWeight(700),
                fontSize = 18.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.success),
            contentDescription = "Login Success Image"
        )
        Text(
            text = "Login Successful",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(50.dp))

        BtnWidget(shapeSize = 50f, btnText = "Continue") {
            navController.navigate(Graph.HOME_GRAPH)
        }
    }


}
