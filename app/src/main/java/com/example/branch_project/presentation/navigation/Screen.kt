package com.example.branch_project.presentation.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("home")
    object ChatScreen : Screen("chat")
}
