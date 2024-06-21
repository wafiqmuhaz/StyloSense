package com.example.stylosense.presentations.page.dashboard_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stylosense.R
import com.example.stylosense.presentations.graph.home_graph.ShopCommercePage
import com.example.stylosense.presentations.page.dashboard_page.view_model.DashboardViewModel


@Composable
fun DashboardPage(
    popularProductState: LazyListState = rememberLazyListState(),
    suggestionProductState: LazyListState = rememberLazyListState(),
    productViewModel: DashboardViewModel = hiltViewModel(),
    navController: NavController,
    onItemClick: (Int) -> Unit
) {

    val state = productViewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
//                .background(color = Color(0xFF4a3298), shape = RoundedCornerShape(10.dp))
                .padding(15.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text("Welcome Back!", color = Color.Black)
            Text(
                "Let’s find your closest\n" +
                        "tailor or laundry!",
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Special for you", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "See More", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(15.dp))
//special offer cart
        LazyRow(
            state = popularProductState,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            item {
                ConstraintLayout(
                    modifier = Modifier
                        .width(320.dp)
                        .height(250.dp)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    //constrains
                    val (bannerText, bannerImage) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_3),
                        contentDescription = "",
                        modifier = Modifier
                        .constrainAs(bannerImage) {}
                        .width(320.dp)
                        .height(250.dp),
                        contentScale = ContentScale.FillHeight
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText) {
                                top.linkTo(bannerImage.top)
                                bottom.linkTo(bannerImage.bottom)
                                start.linkTo(bannerImage.start)
                                end.linkTo(bannerImage.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Fashion",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                        Text(text = "85 Brands", color = Color.White)
                    }


                }
            }
            item {
                //second item
                ConstraintLayout(
                    modifier = Modifier
                        .width(320.dp)
                        .height(250.dp)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    //constrains
                    val (bannerText2, bannerImage2) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_2),
                        contentDescription = "",
                        modifier = Modifier.constrainAs(bannerImage2) {}
                            .width(320.dp)
                            .height(250.dp),
                        contentScale = ContentScale.FillHeight
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText2) {
                                top.linkTo(bannerImage2.top)
                                bottom.linkTo(bannerImage2.bottom)
                                start.linkTo(bannerImage2.start)
                                end.linkTo(bannerImage2.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Accessories",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                        Text(text = "15 Brands", color = Color.White)
                    }
                }
            }
        }



        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Find Service", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            item {
                ConstraintLayout(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { navController.navigate(
//                            ShopCommercePage.FavouritePage.route,
                            ShopCommercePage.TailorListPage.route,
                        ) }
                ) {
                    //constrains
                    val (bannerText, bannerImage) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_3),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.constrainAs(bannerImage) {}
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText) {
                                top.linkTo(bannerImage.top)
                                bottom.linkTo(bannerImage.bottom)
                                start.linkTo(bannerImage.start)
                                end.linkTo(bannerImage.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Taylor",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                    }


                }
            }

            item {
                //second item
                ConstraintLayout(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable { navController.navigate(ShopCommercePage.LaundryPage.route) }
                ) {
                    //constrains
                    val (bannerText2, bannerImage2) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.image_banner_2),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.constrainAs(bannerImage2) {}
                    )
                    Column(
                        modifier = Modifier
                            .background(Color(0x8DB3B0B0))
                            .padding(15.dp)
                            .constrainAs(bannerText2) {
                                top.linkTo(bannerImage2.top)
                                bottom.linkTo(bannerImage2.bottom)
                                start.linkTo(bannerImage2.start)
                                end.linkTo(bannerImage2.end)
                                height = Dimension.fillToConstraints
                                width = Dimension.fillToConstraints
                            }
                    ) {
                        Text(
                            text = "Laundry",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.heightIn(15.dp))
                    }
                }
            }

        }
    }
}