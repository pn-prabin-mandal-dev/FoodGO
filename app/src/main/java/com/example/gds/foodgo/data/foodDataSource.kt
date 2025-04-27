package com.example.gds.foodgo.data

import com.example.gds.foodgo.R

object FoodCardData {
    fun foodList(): List<FoodCardDataClass> {
        return listOf(
            FoodCardDataClass(
                foodImage = R.drawable.beef_burger,
                foodName = "Spicy Veggie Burger",
                foodPrice = "6.49",
                foodDescription = "A fiery twist on the classic veggie burger, packed with fresh vegetables, spicy jalapeños, and creamy chipotle sauce. Served in a toasted multigrain bun.",
                foodRating = "4.3",
                foodDeliveryTime = "20 min",
                index = 0,
                category = "veg"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.veg_burger,
                foodName = "Zinger Chicken Burger",
                foodPrice = "8.29",
                foodDescription = "Crispy, golden-fried chicken fillet, spicy mayo, lettuce, and pickles stacked between soft buns. A true delight for spice lovers.",
                foodRating = "4.6",
                foodDeliveryTime = "18 min",
                index = 1,
                category = "chicken"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.chicken_burger,
                foodName = "Hawaiian Teriyaki Burger",
                foodPrice = "9.49",
                foodDescription = "Juicy beef patty glazed with teriyaki sauce, topped with grilled pineapple, cheese, and fresh greens for a tropical flavor explosion.",
                foodRating = "4.7",
                foodDeliveryTime = "22 min",
                index = 2,
                category = "beef"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.veg_burger,
                foodName = "Classic Beef Burger",
                foodPrice = "7.99",
                foodDescription = "A juicy beef patty grilled to perfection, layered with cheddar cheese, lettuce, tomato, and our signature burger sauce.",
                foodRating = "4.4",
                foodDeliveryTime = "19 min",
                index = 3,
                category = "beef"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.chicken_burger,
                foodName = "Ultimate Chicken Burger",
                foodPrice = "8.79",
                foodDescription = "Tender chicken breast grilled and topped with smoky BBQ sauce, crispy onions, and cheddar cheese in a brioche bun.",
                foodRating = "4.5",
                foodDeliveryTime = "21 min",
                index = 4,
                category = "chicken"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.veg_burger,
                foodName = "Cheesy Veg Delight",
                foodPrice = "6.99",
                foodDescription = "A delicious veggie patty loaded with double cheese, lettuce, tomato, and a splash of tangy special sauce.",
                foodRating = "4.2",
                foodDeliveryTime = "17 min",
                index = 5,
                category = "veg"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.chicken_burger,
                foodName = "Buffalo Chicken Burger",
                foodPrice = "8.49",
                foodDescription = "Crispy chicken tossed in buffalo sauce, cooled off with ranch dressing, crisp lettuce, and pickles on a toasted bun.",
                foodRating = "4.6",
                foodDeliveryTime = "18 min",
                index = 6,
                category = "chicken"
            ),
            // 4 New Items
            FoodCardDataClass(
                foodImage = R.drawable.beef_burger,
                foodName = "Double Beef Stacker",
                foodPrice = "10.99",
                foodDescription = "Two juicy beef patties, double cheddar cheese, crispy bacon, and smoky BBQ sauce layered to create the ultimate burger experience.",
                foodRating = "4.8",
                foodDeliveryTime = "24 min",
                index = 7,
                category = "beef"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.veg_burger,
                foodName = "Paneer Tikka Burger",
                foodPrice = "7.49",
                foodDescription = "Indian flavors meet fast food! Grilled paneer slices marinated in spicy tikka sauce, paired with onion rings and mint mayo.",
                foodRating = "4.5",
                foodDeliveryTime = "20 min",
                index = 8,
                category = "veg"
            ),
            FoodCardDataClass(
                foodImage = R.drawable.veg_burger,
                foodName = "Mushroom Swiss Burger",
                foodPrice = "9.29",
                foodDescription = "Sautéed mushrooms, creamy Swiss cheese, and a juicy beef patty come together to create this rich and savory burger.",
                foodRating = "4.6",
                foodDeliveryTime = "21 min",
                index = 9,
                category = "beef"
            )
        )
    }
}
