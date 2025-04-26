package com.example.gds.foodgo.core.navigation

import android.media.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gds.foodgo.presentation_layer.CartScreen
import com.example.gds.foodgo.presentation_layer.DetailScreen
import com.example.gds.foodgo.presentation_layer.FavouriteScreen
import com.example.gds.foodgo.presentation_layer.HomeScreen
import com.example.gds.foodgo.presentation_layer.ProfileScreen
import com.example.gds.foodgo.presentation_layer.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val navItems = listOf(
        NavItem(
            title = "Home",
            selectedIcon = Icons.Default.Home,
            unSelectedIcon = Icons.Outlined.Home,
            route = Routes.HomeScreen
        ),
        NavItem(
            title = "Cart",
            selectedIcon = Icons.Default.ShoppingCart,
            unSelectedIcon = Icons.Outlined.ShoppingCart,
            route = Routes.CartScreen
        ),
        NavItem(
            title = "Favourite",
            selectedIcon = Icons.Default.Favorite,
            unSelectedIcon = Icons.Outlined.Favorite,
            route = Routes.FavouriteScreen
        ),
        NavItem(
            title = "Me",
            selectedIcon = Icons.Default.Person,
            unSelectedIcon = Icons.Outlined.Person,
            route = Routes.ProfileScreen
        ),
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoutes by navController.currentBackStackEntryAsState()
                val currentDestination = currentRoutes?.destination?.route

                navItems.forEach { item ->
                    val selected = currentDestination == item.route::class.qualifiedName
                    NavigationBarItem(
                        icon = {
                            Icon(
                                if (selected) item.selectedIcon else item.unSelectedIcon,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) },
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HomeScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Routes.SplashScreen> {
                SplashScreen(navController)
            }
            composable<Routes.HomeScreen> {
                HomeScreen()
            }
            composable<Routes.DetailScreen> {
                DetailScreen(navController)
            }
            composable<Routes.CartScreen> {
                CartScreen()
            }
            composable<Routes.FavouriteScreen> {
                FavouriteScreen()
            }
            composable<Routes.ProfileScreen> {
                ProfileScreen(navController = navController)
            }

            composable<Routes.ExtraAddingScreen> {

            }
            composable<Routes.PaymentScreen> {

            }
            composable<Routes.SuccessScreen> {

            }
        }
    }
}

data class NavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: Routes,
)