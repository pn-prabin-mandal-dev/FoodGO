package com.example.gds.foodgo.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.gds.foodgo.presentation_layer.CartScreen
import com.example.gds.foodgo.presentation_layer.DetailScreen
import com.example.gds.foodgo.presentation_layer.FavouriteScreen
import com.example.gds.foodgo.presentation_layer.HomeScreen
import com.example.gds.foodgo.presentation_layer.LoginScreen
import com.example.gds.foodgo.presentation_layer.PaymentScreen
import com.example.gds.foodgo.presentation_layer.ProfileScreen
import com.example.gds.foodgo.presentation_layer.SignUpScreen
import com.example.gds.foodgo.presentation_layer.SplashScreen
import com.example.gds.foodgo.presentation_layer.SuccessScreen

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
            unSelectedIcon = Icons.Outlined.FavoriteBorder,
            route = Routes.FavouriteScreen
        ),
        NavItem(
            title = "Me",
            selectedIcon = Icons.Default.Person,
            unSelectedIcon = Icons.Outlined.Person,
            route = Routes.ProfileScreen
        ),
    )

    // List of routes where the bottom bar should be hidden
    val routesWithoutBottomBar = listOf(
        Routes.SplashScreen::class.qualifiedName,
        Routes.LoginScreen::class.qualifiedName,
        Routes.SignUpScreen::class.qualifiedName,
        Routes.SuccessScreen::class.qualifiedName
    )

    Scaffold(
        bottomBar = {
            val currentRoute by navController.currentBackStackEntryAsState()
            val currentDestination = currentRoute?.destination?.route

            // Show bottom bar only if the current route is not in routesWithoutBottomBar
            if (currentDestination !in routesWithoutBottomBar) {
                NavigationBar {
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
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.SplashScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Routes.SplashScreen> {
                SplashScreen(navController)
            }
            composable<Routes.HomeScreen> {
                HomeScreen(navController = navController)
            }
            composable<Routes.DetailScreen> { backStackEntry ->
                val data = backStackEntry.toRoute<Routes.DetailScreen>()
                DetailScreen(navController, foodIndex = data.foodIndex)
            }
            composable<Routes.CartScreen> {
                CartScreen(navController)
            }
            composable<Routes.FavouriteScreen> {
                FavouriteScreen(navController = navController)
            }
            composable<Routes.ProfileScreen> {
                ProfileScreen(navController = navController)
            }

            composable<Routes.PaymentScreen> {
                PaymentScreen(navController)
            }
            composable<Routes.SuccessScreen> {
                SuccessScreen(navController)
            }
            composable<Routes.LoginScreen> {
                LoginScreen(navController)
            }
            composable<Routes.SignUpScreen> {
                SignUpScreen(navController = navController)
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