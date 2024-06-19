package com.example.stylosense.presentations.page.sign_up_page

import android.util.Patterns
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.widgets.BackWidget
import com.example.stylosense.presentations.widgets.BtnWidget
import com.example.stylosense.presentations.widgets.ErrorWidget
import com.example.stylosense.presentations.widgets.FieldWidget


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SignUpPage(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPass by remember { mutableStateOf(TextFieldValue("")) }
    var firstName by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var address by remember { mutableStateOf(TextFieldValue("")) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val conPasswordErrorState = remember { mutableStateOf(false) }
    val firstNameErrorState = remember { mutableStateOf(false) }
    val lastNameErrorState = remember { mutableStateOf(false) }
    val phoneNumberErrorState = remember { mutableStateOf(false) }
    val addressErrorState = remember { mutableStateOf(false) }
    val animate = remember { mutableStateOf(true) }


    AnimatedContent(targetState = animate.value, transitionSpec = {
        slideInHorizontally(
            initialOffsetX = { value ->
                value
            }
        ) with slideOutHorizontally(
            targetOffsetX = { value ->
                -value
            }
        )
    }) {
        if (it) {
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
                        Text(
                            text = "Sign Up",
                            color = Color.Black,
                            fontSize = 18.sp)
//                        )
                    }


                }
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "Register Account", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Complete your details or continue\nwith social media.",
                    color = Color.Black,
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


                Spacer(modifier = Modifier.height(20.dp))
                FieldWidget(
                    placeholder = "********",
                    trailingIcon = R.drawable.lock,
                    label = "Confirm Password",
                    keyboardType = KeyboardType.Password,
                    errorState = conPasswordErrorState,
                    visualTransformation = PasswordVisualTransformation(),
                    onChanged = { newPass ->
                        confirmPass = newPass
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
                if (conPasswordErrorState.value) {
                    ErrorWidget("Confirm Password miss matched.")
                }
                BtnWidget(shapeSize = 50f, btnText = "Continue") {
                    //email pattern
                    val pattern = Patterns.EMAIL_ADDRESS
                    val isEmailValid = pattern.matcher(email.text).matches()
                    val isPassValid = password.text.length >= 8
                    val conPassMatch = password == confirmPass
                    emailErrorState.value = !isEmailValid
                    passwordErrorState.value = !isPassValid
                    conPasswordErrorState.value = !conPassMatch
                    if (isEmailValid && isPassValid && conPassMatch) {
                        animate.value = !animate.value
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                            .clickable {

                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "By continuing you confirm that you agree",
                            color = Color.Black,
                        )
                        Row()
                        {
                            Text(
                                text = "with our ",
                                color = Color.Black,
                            )
                            Text(
                                text = "Terms & Condition",
                                color = Color.Black,
                                modifier = Modifier.clickable {

                                })
                        }

                    }
                }


            }
        } else {
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
                            animate.value = !animate.value
                        }
                    }
                    Box(modifier = Modifier.weight(1.0f)) {
                        Text(
                            text = "Sign Up",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }


                }
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "Complete Profile", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Complete your details or continue\nwith social media.",
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(50.dp))
                FieldWidget(
                    placeholder = "Enter your first name",
                    trailingIcon = R.drawable.user,
                    label = "First Name",
                    errorState = firstNameErrorState,
                    keyboardType = KeyboardType.Text,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newText ->
                        firstName = newText
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                FieldWidget(
                    placeholder = "Enter your last name",
                    trailingIcon = R.drawable.user,
                    label = "Last Name",
                    errorState = lastNameErrorState,
                    keyboardType = KeyboardType.Text,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newText ->
                        lastName = newText
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))
                FieldWidget(
                    placeholder = "Enter your phone number",
                    trailingIcon = R.drawable.phone,
                    label = "Phone Number",
                    keyboardType = KeyboardType.Phone,
                    errorState = phoneNumberErrorState,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newNumber ->
                        phoneNumber = newNumber
                    }
                )


                Spacer(modifier = Modifier.height(20.dp))
                FieldWidget(
                    placeholder = "example: Bandung, Jawa Barat",
                    trailingIcon = R.drawable.location_point,
                    label = "Address",
                    keyboardType = KeyboardType.Password,
                    errorState = addressErrorState,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newText ->
                        address = newText
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (firstNameErrorState.value || lastNameErrorState.value) {
                    ErrorWidget("Please enter valid name.")
                }
                if (phoneNumberErrorState.value) {
                    ErrorWidget("Please enter valid phone number.")
                }
                if (addressErrorState.value) {
                    ErrorWidget("Please enter valid address.")
                }

                BtnWidget(shapeSize = 50f, btnText = "Continue") {
                    val isPhoneValid = phoneNumber.text.isEmpty() || phoneNumber.text.length < 4
                    val isFNameValid = firstName.text.isEmpty() || firstName.text.length < 3
                    val isLNameValid = lastName.text.isEmpty() || lastName.text.length < 3
                    val isAddressValid = address.text.isEmpty() || address.text.length < 5
                    firstNameErrorState.value = !isFNameValid
                    lastNameErrorState.value = !isLNameValid
                    addressErrorState.value = !isAddressValid
                    phoneNumberErrorState.value = !isPhoneValid
                    if (!isFNameValid && !isLNameValid && !isAddressValid && !isPhoneValid) {
//                        navController.navigate(AuthPage.OTPScreen.route)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .clickable {

                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "By continuing you confirm that you agree",
                        color = Color.Black,
                    )
                    Row()
                    {
                        Text(
                            text = "with our ",
                            color = Color.Black,
                        )
                        Text(
                            text = "Terms & Condition",
                            color = Color.Black,
                            modifier = Modifier.clickable {

                            })
                    }

                }
            }


        }
    }
}