package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gds.foodgo.R
import com.example.gds.foodgo.data.FoodCardData

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreen(modifier: Modifier = Modifier) {
    val allFoods = FoodCardData.foodList()
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("all") }

    val categories = listOf("all", "beef", "chicken", "veg")

    val filteredFoods = allFoods.filter {
        (selectedCategory == "all" || it.category.equals(selectedCategory, ignoreCase = true)) &&
                it.foodName.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = modifier.padding(16.dp)) {
        SearchBar(searchQuery) { searchQuery = it }
        Spacer(modifier = Modifier.height(8.dp))
        CategoryFilter(categories, selectedCategory) { selectedCategory = it }
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(filteredFoods) {food->
                FoodCard(foodIndex = food.index)
            }
        }
    }
}

@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    Card (
        modifier = Modifier.fillMaxWidth()
    ){
        TextField(
            value = query,
            onValueChange = onQueryChange,
            label = { Text("Search Burgers", fontSize = 16.sp) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }
}

@Composable
fun CategoryFilter(categories: List<String>, selected: String, onSelect: (String) -> Unit) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(categories) { category ->
            FilterChip(
                selected = category == selected,
                onClick = { onSelect(category) },
                label = { Text(category) }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FoodCard(
    foodIndex: Int = 0,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val context = LocalContext.current
    var isFav by remember { mutableStateOf(false) }
    val foodData = FoodCardData.foodList()[foodIndex]
    Card(
        modifier = Modifier
            .clickable {
                onClick()
                Toast.makeText(context, "Clicked ${foodData.index}", Toast.LENGTH_SHORT).show()
            }
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),// Ensures proper corner cutting
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White.copy(0.4f)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        )
    ) {
        Box(
            modifier = Modifier
                .height(240.dp)
                .width(180.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(top = 12.dp).padding(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    painter = painterResource(id = foodData.foodImage),
                    contentDescription = "Burger",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(80.dp)
                        .align(Alignment.CenterHorizontally),
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = foodData.foodName,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = foodData.foodDescription,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(
                            modifier = Modifier.weight(0.8f),
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Image(
                                painter = painterResource(R.drawable.login_screen_burger_img),
                                contentDescription = "star Icon",
                                modifier = Modifier.size(18.dp),
                            )
                            Text(
                                text = foodData.foodRating,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                        }

                        IconButton(
                            onClick = {isFav = !isFav},
                            modifier = Modifier.wrapContentSize()
                        ) {
                            Icon(
                                if (isFav) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favorite Icon",
                                tint = colorResource(R.color.gradient_end_color),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


