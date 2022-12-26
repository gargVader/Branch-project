package com.example.branch_project.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.branch_project.presentation.home.HomeScreen
import com.example.branch_project.presentation.login.LoginScreen

@Composable
fun RootNavGraph(navController: NavHostController) {



    NavHost(
        navController = navController,
        route = NAV_GRAPH_ROOT,
        startDestination = Screen.LoginScreen.route
    ) {
        // Define all routes

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        homeNavGraph(navController)

    }

}