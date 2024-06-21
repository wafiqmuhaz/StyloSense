package com.example.stylosense.presentations.page.sign_up_page

import android.util.Patterns
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.auth_graph.AuthPage
import com.example.stylosense.presentations.widgets.BackWidget
import com.example.stylosense.presentations.widgets.BtnWidget
import com.example.stylosense.presentations.widgets.ErrorWidget

@Composable
fun SignUpPage(navController: NavController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPass by remember { mutableStateOf(TextFieldValue("")) }
    val nameErrorState = remember { mutableStateOf(false) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val conPasswordErrorState = remember { mutableStateOf(false) }
    val animate = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Box(modifier = Modifier.weight(0.7f)) {
                BackWidget {
                    navController.popBackStack()
                }
            }
            Box(modifier = Modifier.weight(1.0f)) {
                Text(text = "Register", color = MaterialTheme.colorScheme.outline, fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.height(45.dp))
        Image(
            painter = painterResource(id = R.drawable.tailor_kid),
            contentDescription = "Ilustration",
            modifier = Modifier.size(170.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = confirmPass,
            onValueChange = { confirmPass = it },
            label = { Text("Confirm Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(10.dp))
        if (emailErrorState.value) {
            ErrorWidget("Please enter valid email address.")
        }
        if (passwordErrorState.value) {
            Row() {
                ErrorWidget("Please enter valid password.")
            }
        }
        BtnWidget(shapeSize = 50f, btnText = "Register") {
            val pattern = Patterns.EMAIL_ADDRESS
            val isNameValid = pattern.matcher(name.text).matches()
            val isEmailValid = pattern.matcher(email.text).matches()
            val isPassValid = password.text.length >= 8
            val conPassMatch = password == confirmPass
            nameErrorState.value = !isNameValid
            emailErrorState.value = !isEmailValid
            passwordErrorState.value = !isPassValid
            conPasswordErrorState.value = !conPassMatch
            if (isEmailValid && isPassValid && conPassMatch) {
                animate.value = !animate.value
                navController.navigate(AuthPage.SignInPage.route)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an account? ", color = Color.Black)
            Text(
                text = "Sign In!",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    navController.navigate(AuthPage.SignInPage.route)
                })
        }
    }
}