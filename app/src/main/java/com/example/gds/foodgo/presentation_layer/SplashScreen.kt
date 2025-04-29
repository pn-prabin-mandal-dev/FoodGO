package com.example.gds.foodgo.presentation_layer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gds.foodgo.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gds.foodgo.core.navigation.Routes
import kotlinx.coroutines.delay

@Composable
@Preview(showBackground = true)
fun SplashScreen(navController: NavController = rememberNavController()) {
    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate(Routes.HomeScreen) {
            popUpTo(Routes.SplashScreen) { inclusive = true }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),

        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(R.color.gradient_start_color),
                            colorResource(R.color.gradient_end_color)
                        ),
                        start = Offset(0.5f, 0f),
                        end = Offset(1000f, 1000f)
                    )
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foodgo),
                    contentDescription = "FoodGo Logo",
                    modifier = Modifier
                        .height(600.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Box (
                    modifier = Modifier.weight(3f),
                    contentAlignment = Alignment.BottomStart
                ){
                    Image(
                        painter = painterResource(id = R.drawable.left_burger_splash),
                        contentDescription = "Left Burger",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Crop
                    )
                    Box (
                        modifier = Modifier.padding(start = 130.dp),
                        contentAlignment = Alignment.BottomCenter
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.burger_splash_second),
                            contentDescription = "Right Burger",
                            modifier = Modifier.size(130.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

            }
        }
    }
}