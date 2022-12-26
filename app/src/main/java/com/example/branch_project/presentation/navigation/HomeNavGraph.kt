package com.example.branch_project.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.branch_project.presentation.chat.ChatScreen
import com.example.branch_project.presentation.home.HomeScreen
import com.example.branch_project.presentation.home.HomeViewModel

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.HomeScreen.route,
        route = NAV_GRAPH_HOME,
    ) {

        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.ChatScreen.route + "/{$ARG_CHAT_THREAD_ID}",
            arguments = listOf(
                navArgument(ARG_CHAT_THREAD_ID) {
                    type = NavType.IntType
                    nullable = false
                }
            )
        ) {
            val threadId = it.arguments?.get(ARG_CHAT_THREAD_ID) as Int
            ChatScreen(navController = navController, threadId = threadId)
        }

    }
}