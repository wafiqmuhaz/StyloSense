package com.example.stylosense.presentations.page.sign_in_page

import android.util.Patterns
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.auth_graph.AuthPage
import com.example.stylosense.presentations.widgets.BackWidget
import com.example.stylosense.presentations.widgets.BtnWidget
import com.example.stylosense.presentations.widgets.ErrorWidget
import com.example.stylosense.presentations.widgets.FieldWidget


@Composable
fun SignInPage(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var checkBox by remember {
        mutableStateOf(false)
    }
    val emailErrorState = remember {
        mutableStateOf(false)
    }
    val passwordErrorState = remember {
        mutableStateOf(false)
    }


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
                Text(text = "Sign in", color = MaterialTheme.colorScheme.outline, fontSize = 18.sp)
            }


        }
        Spacer(modifier = Modifier.height(35.dp))
        Text(text = "Let's Get You Back in!", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Sign in with your email or password\nor continue with social media.",
            color = MaterialTheme.colorScheme.outline,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        FieldWidget(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.mail,
            label = "Email",
            errorState = emailErrorState,
            keyboardType = KeyboardType.Email,
            visualTransformation = VisualTransformation.None,
            onChanged = { newEmail ->
                email = newEmail
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        FieldWidget(
            placeholder = "********",
            trailingIcon = R.drawable.lock,
            label = "Password",
            keyboardType = KeyboardType.Password,
            errorState = passwordErrorState,
            visualTransformation = PasswordVisualTransformation(),
            onChanged = { newPass ->
                password = newPass
            }
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
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 15.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Checkbox(
//                    checked = checkBox, onCheckedChange = {
//                        checkBox = it
//                    },
//                    colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colorScheme.primary)
//                )
//                Text(text = "Remember me", color = MaterialTheme.colorScheme.outline, fontSize = 14.sp)
//            }
//            Text(
//                text = "Forget Password",
//                color = MaterialTheme.colorScheme.outline,
//                style = TextStyle(textDecoration = TextDecoration.Underline),
//                modifier = Modifier.clickable {
//                    navController.navigate(AuthPage.ForgetPasswordScreen.route)
//                }
//            )
//        }
        BtnWidget(shapeSize = 50f, btnText = "Continue") {
            //email pattern
            val pattern = Patterns.EMAIL_ADDRESS
            val isEmailValid = pattern.matcher(email.text).matches()
            val isPassValid = password.text.length >= 8
            emailErrorState.value = !isEmailValid
            passwordErrorState.value = !isPassValid
            if (isEmailValid && isPassValid) {
                navController.navigate(AuthPage.SignInSuccessPage.route)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account? ", color = Color.Black)
                Text(
                    text = "Sign Up",
                    color = Color.Blue,
                    modifier = Modifier.clickable {
                        navController.navigate(AuthPage.SignUpPage.route)
                    })
            }
        }


    }
}