package com.example.gds.foodgo.presentation_layer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gds.foodgo.R
import com.example.gds.foodgo.core.components.PrimaryButton
import com.example.gds.foodgo.core.navigation.Routes

@Composable
fun CartScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(18.dp))
            Text("My Cart", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                Text(
                    "The Burger Place",
                    modifier = Modifier,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.black),
                    textDecoration = TextDecoration.Underline
                )
            }
            Column {
                BurgerCardCart()
                BurgerCardCart()

            }
            Spacer(modifier = Modifier.height(62.dp))
            Card (
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp)
            ){
                Row(
                    modifier = Modifier.height(60.dp).fillMaxWidth()
                ) {
                    var promoCodeText by remember { mutableStateOf("") }
                    TextField(
                        value = promoCodeText,
                        onValueChange = {promoCodeText = it},
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            ),
                        modifier = Modifier.padding(start = 16.dp),
                        placeholder = {Text("Enter Promo Code", modifier = Modifier.padding(start = 4.dp))}
                    )
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxHeight().fillMaxWidth().background(color = colorResource(R.color.gradient_end_color)).clip(
                        RoundedCornerShape(topStart = 0.dp, bottomStart = 0.dp,))){
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Send, contentDescription = "Send Icon", tint = Color.White)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(80.dp))
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text("Address", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("janakpurdham-3", fontWeight = FontWeight.SemiBold)
                }
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text("Delivery", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("$  ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("86.44", fontWeight = FontWeight.SemiBold)
                    }
                }
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Text("Total", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("$  ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("86.44", fontWeight = FontWeight.SemiBold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Box(modifier = Modifier.fillMaxWidth().height(120.dp), contentAlignment = Alignment.BottomCenter){
                PrimaryButton(onClick = {navController.navigate(Routes.PaymentScreen)}, text = "Checkout")
            }
        }
    }
}

@Composable
fun BurgerCardCart() {
    var itemCount by remember { mutableStateOf(1) }
    Spacer(modifier = Modifier.height(18.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        elevation = CardDefaults.elevatedCardElevation(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Card(shape = RoundedCornerShape(12.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.veg_burger),
                        contentDescription = "Burger image",
                        modifier = Modifier
                            .width(80.dp)
                            .height(160.dp)
                    )
                }
            }
            Box() {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(vertical = 12.dp)
                        .padding(end = 12.dp), verticalArrangement = Arrangement.Center
                ) {
                    Column(modifier = Modifier) {
                        Text("HamBurger Fried Chicken Burger", fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.AccessTime,
                                    contentDescription = "AccessTime"
                                )
                                Text(" 30 min", fontWeight = FontWeight.SemiBold)
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.Star, tint = Color.Yellow.copy(0.6f),
                                    modifier = Modifier,
                                    contentDescription = "AccessTime"
                                )
                                Text(" 4.3", fontWeight = FontWeight.SemiBold)
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "$12.44",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 18.sp,
                                color = colorResource(R.color.gradient_end_color)
                            )

                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                Card(colors = CardDefaults.cardColors(containerColor = colorResource(R.color.gradient_end_color)),modifier = Modifier.width(30.dp).height(40.dp)) {
                                    IconButton(onClick = {if(itemCount>1) itemCount--}) {
                                        Icon(
                                            painterResource(R.drawable.minus),
                                            contentDescription = "Delete Icon",
                                            tint = Color.White,
                                            modifier = Modifier.width(16.dp)
                                        )
                                    }
                                }
                                Text(text = "$itemCount", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                                Card(colors = CardDefaults.cardColors(containerColor = colorResource(R.color.gradient_end_color)),modifier = Modifier.width(30.dp).height(40.dp)) {
                                    IconButton(onClick = {itemCount++}) {
                                        Icon(
                                            Icons.Default.Add,
                                            contentDescription = "Add Icon",
                                            tint = Color.White
                                        )
                                    }
                                }

                            }
                        }

                    }
                }
            }
        }
    }
}