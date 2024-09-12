package com.purple.myapps02

sealed class NavigationItem(val route: String) {
    object Home : NavigationItem("home")
    object Detail : NavigationItem("detail")
    object New : NavigationItem("new")
}