package com.purple.myapps02

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(
            route = "home"
        ) {
            HomeScreen(navController)
        }

        composable(
            route = "detail/{itemId}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.StringType
                }
            )
        ) {
            val itemId = it.arguments?.getString("itemId")
            DetailScreen(navController, itemId)
        }

        composable(
            route = "new"
        ) {
            NewScreen(navController)
        }

        composable(
            route = "new/{itemId}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.StringType
                }
            )
        ) {
            val itemId = it.arguments?.getString("itemId")
            NewScreen(navController, itemId)
        }

    }

}