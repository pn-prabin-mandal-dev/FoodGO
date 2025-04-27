package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import com.example.gds.foodgo.R
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gds.foodgo.core.components.PrimaryButton
import com.example.gds.foodgo.core.navigation.Routes

@Composable
@Preview(showBackground = true)
fun PaymentScreen(navController: NavController = rememberNavController()) {
    var isChecked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Top Icons (Back and Search)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    // Explicitly navigate to HomeScreen instead of popping back
                    navController.navigate(Routes.HomeScreen) {
                        popUpTo(Routes.HomeScreen) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Arrow_back icon",
                    tint = Color.Black.copy(0.6f),
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Order Summary
        Text("Order Summary", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Order", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)
            Text("$16.48", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Taxes", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)
            Text("$0.48", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Delivery Fees", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)
            Text("$1.8", fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Total", fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = Color.Black.copy(0.8f))
            Text("$16.48", fontSize = 22.sp, fontWeight = FontWeight.SemiBold, color = Color.Black.copy(0.8f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text("Estimate Delivery Time", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Black.copy(0.8f))
            Text("15 - 30min", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.Black.copy(0.8f))
        }

        Spacer(modifier = Modifier.height(38.dp))

        // Payment Method Section
        Text("Payment method:", fontWeight = FontWeight.Bold, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        PaymentCard(
            brand = "MasterCard",
            cardType = "Credit card",
            number = "5105 **** **** 0505",
            isSelected = true,
            numberColor = Color.Gray,
            bgColor = Color(0xFF3B2F2F),
            cardIcon = painterResource(R.drawable.master_card),
            cardTypeColor = Color.White.copy(0.8f)
        )

        Spacer(modifier = Modifier.height(30.dp))

        PaymentCard(
            brand = "Visa",
            cardType = "Debit card",
            number = "3566 **** **** 0505",
            isSelected = false,
            numberColor = Color.Gray,
            bgColor = Color(0xFFD1E2EC),
            cardIcon = painterResource(R.drawable.visa_icon),
            cardTypeColor = Color(0xFF333232)
        )

        Spacer(modifier = Modifier.height(26.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
            ){
                Checkbox(checked = isChecked, onCheckedChange = {isChecked = it}, modifier = Modifier, colors = CheckboxDefaults.colors(
                    checkedColor = colorResource(R.color.gradient_end_color)
                ))
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Save card details for future payment",
                fontSize = 16.sp,
                modifier = Modifier.clickable{
                    isChecked = !isChecked
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Payment Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("Total price", fontSize = 14.sp)
                Text(
                    "$18.19",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            PrimaryButton(
                onClick = {
                    navController.navigate(Routes.SuccessScreen) {
                        popUpTo(Routes.HomeScreen) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                text = "Pay Now"
            )
        }
    }
}

@Composable
fun PaymentCard(
    brand: String,
    cardType: String,
    number: String,
    numberColor: Color = Color.Black,
    isSelected: Boolean,
    bgColor: Color,
    cardIcon: Painter = painterResource(R.drawable.visa_icon),
    cardTypeColor: Color = Color.Black
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                ){
                    Image(painter = cardIcon, contentDescription = "")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(cardType, color = cardTypeColor, fontWeight = FontWeight.SemiBold)
                    Text(
                        number,
                        fontSize = 12.sp,
                        color = numberColor
                    )
                }
            }

            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Selected",
                    tint = Color.White
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .border(1.dp, Color.Gray, CircleShape)
                )
            }
        }
    }
}