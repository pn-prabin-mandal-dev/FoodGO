package com.example.gds.foodgo.data

data class FoodCardDataClass(
    val foodImage: Int,  // Store Int resource ID, not Painter
    val foodName: String,
    val foodPrice: String,
    val foodDescription: String,
    val foodRating: String,
    val foodDeliveryTime: String,
    val index: Int,
    val category: String,
)