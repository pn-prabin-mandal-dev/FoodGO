package com.example.gds.foodgo.core.navigation

import kotlinx.serialization.Serializable

sealed class Routes{
    @Serializable
    object SplashScreen: Routes()
    @Serializable
    object LoginScreen: Routes()

    @Serializable
    object SignUpScreen: Routes()

    @Serializable
    object HomeScreen: Routes()

    @Serializable
    data class DetailScreen(
        val foodIndex: Int
    )

    @Serializable
    object CartScreen: Routes()
    @Serializable
    object FavouriteScreen: Routes()

    @Serializable
    object ProfileScreen: Routes()

    @Serializable
    object ExtraAddingScreen: Routes()

    @Serializable
    object PaymentScreen: Routes()

    @Serializable
    object SuccessScreen: Routes()





}