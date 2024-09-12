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
            route = NavigationItem.Home.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = "${NavigationItem.Detail.route}/{itemId}/{extra}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.StringType
                },
                navArgument("extra") {
                    type = NavType.IntType
                }
            )
        ) {
            val itemId = it.arguments?.getString("itemId")
            val extra = it.arguments?.getInt("extra")
            DetailScreen(navController, itemId, extra)
        }

        composable(
            route = NavigationItem.New.route
        ) {
            NewScreen(navController)
        }

        composable(
            route = "${NavigationItem.New.route}/{itemId}",
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