package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.foodgo.R
import com.example.gds.foodgo.core.navigation.Routes

@Composable
fun DetailScreen(navController: NavController) {
    var quantity by remember { mutableStateOf(2) }
    var spicyLevel by remember { mutableStateOf(0.5f) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
    ) {
        // top icon
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {navController.popBackStack()}
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Arrow_back icon",
                        tint = Color.Black.copy(0.6f),
                        modifier = Modifier.size(32.dp)
                    )
                }
                IconButton(
                    onClick = {
                        Toast.makeText(context, "Searched", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Setting Icon",
                        tint = Color.Black.copy(0.6f),
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        }

        // Top image
        Image(
            painter = painterResource(id = R.drawable.veg_burger), // Replace with your image
            contentDescription = "Burger",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp)),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Title & rating
        Text("CheeseBurger Wendy’s Burger", color = Color.Black.copy(0.8f), fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Star, contentDescription = "Rating", tint = Color(0xFFFFA000), modifier = Modifier.size(20.dp))
            Text(" 4.9", fontSize = 14.sp)
            Text("  •  26 mins", fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Text(
            text = "The CheeseBurger Wendy’s Burger is a classic fast food burger that packs a punch of flavour in every bitefood burger that packs a punch of flavour in every bitefood burger that packs a punch of flavour in every bitefood burger that packs a punch of flavour in every bitefood burger that packs a punch of flavour in every bitefood burger that packs a punch of flavour in every bite...",
            fontSize = 14.sp,
            maxLines = 6,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Spicy Slider and Quantity
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text("Spicy", fontWeight = FontWeight.SemiBold)
                Slider(
                    value = spicyLevel,
                    onValueChange = { spicyLevel = it },
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Red,
                        activeTrackColor = Color.Red
                    ),
                    modifier = Modifier.width(150.dp)
                )
                Row (
                    modifier = Modifier
                        .width(150.dp)
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Mild", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Green.copy(0.6f))
                    Spacer(modifier = Modifier.width(40.dp))
                    Text("Hot", fontSize = 12.sp, color = Color.Red)
                }
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Portion", fontWeight = FontWeight.SemiBold)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 4.dp),

                    ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(12.dp)) // Clip first
                            .background(Color.Red)           // Then apply background
                        ,
                    ){
                        IconButton(onClick = { if (quantity > 1) quantity-- }) {
                            Icon(Icons.Default.Delete, contentDescription = "Decrease", tint = Color.White)
                        }
                    }
                    Text("$quantity", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(horizontal = 8.dp))

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(12.dp)) // Clip first
                            .background(Color.Red)           // Then apply background
                        ,
                    ) {
                        IconButton(onClick = { quantity++ }) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Increase",
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Bottom Buttons
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* handle price click */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3D00)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                ) {
                    Text("$8.24", color = Color.White, fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.width(28.dp))

                Button(
                    onClick = { navController.navigate(Routes.PaymentScreen) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF523A32)),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .weight(2f)
                        .height(56.dp)
                ) {
                    Text("ORDER NOW", color = Color.White.copy(0.8f), fontSize = 20.sp, fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}