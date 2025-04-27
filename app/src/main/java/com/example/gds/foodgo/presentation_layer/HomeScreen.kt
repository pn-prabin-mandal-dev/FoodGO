package com.example.gds.foodgo.presentation_layer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gds.foodgo.R
import com.example.gds.foodgo.core.navigation.Routes
import com.example.gds.foodgo.data.FoodCardData

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {
    val allFoods = FoodCardData.foodList()
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("all") }

    val categories = listOf("all", "beef", "chicken", "veg")

    val filteredFoods = allFoods.filter {
        (selectedCategory == "all" || it.category.equals(selectedCategory, ignoreCase = true)) &&
                it.foodName.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Image(
                painter = painterResource(R.drawable.foodgo_logo),
                contentDescription = "FoodGo Logo",
                modifier = Modifier
                    .width(80.dp) // increased width
                    .height(60.dp) // added height
            )
        }
        SearchBar(searchQuery) { searchQuery = it }
        Spacer(modifier = Modifier.height(8.dp))
        CategoryFilter(categories, selectedCategory) { selectedCategory = it }
        Spacer(modifier = Modifier.height(8.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(filteredFoods) {food->
                FoodCard(foodIndex = food.index, navController = navController)
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
fun CategoryFilter(
    categories: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    val redColor = Color.Red
    val hoverColor = Color.LightGray // Color when hovered

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selected
            var isHovered by remember { mutableStateOf(false) } // Track hover state

            FilterChip(
                selected = isSelected,
                onClick = { onSelect(category) },
                label = { Text(category) },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (isSelected) redColor else Color.Transparent,
                    selectedContainerColor = redColor,
                    labelColor = if (isSelected) Color.White else Color.Black,
                    selectedLabelColor = Color.White
                ),
                border = if (!isSelected) {
                    FilterChipDefaults.filterChipBorder(
                        borderColor = if (isHovered) hoverColor else redColor,
                        borderWidth = 1.dp,
                        enabled = true,
                        selected = false
                    )
                } else {
                    null // No border when selected
                },

            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun FoodCard(
    foodIndex: Int = 0,
    navController: NavController = rememberNavController()
) {
    val context = LocalContext.current
    var isAddedToCard by remember { mutableStateOf(false) }
    val foodData = FoodCardData.foodList()[foodIndex]

        Card(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navController.navigate(Routes.DetailScreen(foodIndex))
                },
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
        Column(
            modifier = Modifier
                .width(180.dp)
                .height(240.dp)
                .padding(12.dp)
                .background(Color.Transparent)
                .clip(RoundedCornerShape(12.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = foodData.foodImage),
                contentDescription = foodData.foodName,
                modifier = Modifier
                    .size(80.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = foodData.foodName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )

            Text(
                text = foodData.foodDescription,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.star_img),
                        contentDescription = "Rating Star",
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = foodData.foodRating,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                }

                IconButton(
                    onClick = { isAddedToCard = !isAddedToCard
                        Toast.makeText(context, "added to Cart", Toast.LENGTH_SHORT).show()
                    }

                ) {
                    Icon(
                        imageVector = if (isAddedToCard) Icons.Default.ShoppingCart else Icons.Outlined.ShoppingCart,
                        contentDescription = "Shopping Cart Icon",
                        tint = colorResource(R.color.gradient_end_color),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
