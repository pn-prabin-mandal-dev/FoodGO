package com.example.gds.foodgo.presentation_layer


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gds.foodgo.R
import com.example.gds.foodgo.core.navigation.Routes
import com.example.gds.foodgo.data.FoodCardData

@Composable
fun FavouriteScreen(navController: NavController) {
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
            Text("My Favorites", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                FavoriteCard(1, navController = navController)
                FavoriteCard(2, navController = navController)
                FavoriteCard(3, navController = navController)
            }
        }
    }
}

@Composable
fun FavoriteCard(foodIndex: Int, navController: NavController) {
    val foodData = FoodCardData.foodList()[foodIndex]
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp).clickable{
                navController.navigate(Routes.DetailScreen(foodIndex))
            },
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id =foodData.foodImage),
                contentDescription = "Burger Image",
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .weight(1f)
            ) {
                Text(foodData.foodName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Star, contentDescription = "Rating Icon", tint = Color.Yellow.copy(0.7f))
                    Text(foodData.foodRating, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(foodData.foodPrice, fontWeight = FontWeight.ExtraBold, color = colorResource(R.color.gradient_end_color), fontSize = 16.sp)
            }
        }
    }
}