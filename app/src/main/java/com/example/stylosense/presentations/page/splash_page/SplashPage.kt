package com.example.stylosense.presentations.page.splash_page

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.auth_graph.AuthPage
import com.example.stylosense.presentations.widgets.BtnWidget
import com.example.stylosense.presentations.widgets.DottedWidget
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


fun String.toColor() = Color(android.graphics.Color.parseColor(this))
val Purple = "#5A08B8".toColor()

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun SplashPage(navController: NavController) {
    val splashImageList = listOf(
        R.drawable.splash_1,
        R.drawable.splash_2,
        R.drawable.splash_3,
    )
    val currentPosition = remember { mutableStateOf(0) }
    val animate = remember { mutableStateOf(true) }
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        AnimatedContent(
            targetState = animate.value,
            modifier = Modifier
                .fillMaxWidth(),
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
                ) with slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .padding(top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    ) {
                        Image(
                            painter = painterResource(id = splashImageList[currentPosition.value]),
                            contentDescription = "Splash Image",
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Welcome to StyloSense!",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.muli_bold)),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    when (currentPosition.value) {
                        0 -> {
                            Text(
                                text = buildAnnotatedString {
                                    append("The all in one app for your clothes and laundry")
                                    addStyle(
                                        style = SpanStyle(
                                            color = Color.Black,
                                            fontSize = 21.sp
                                        ),
                                        start = 0,
                                        end = length
                                    )
                                },
                                modifier = Modifier.padding(horizontal = 16.dp),
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.muli))
                            )
                        }
                        1 -> {
                            Text(
                                text = "The all in one app for your clothes and laundry",
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        else -> {
                            Text(
                                text = "The all in one app for your clothes and laundry",
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        )

        DottedWidget(splashImageList.size, currentPosition.value)

        Button(
            onClick = {
                if (currentPosition.value < 2) {
                    currentPosition.value++
                    animate.value = !animate.value
                } else {
                    navController.navigate(AuthPage.SignInPage.route)
                }
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Purple)
        ) {
            Text(
                text = "Continue",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.muli_bold))
            )
        }
    }
}