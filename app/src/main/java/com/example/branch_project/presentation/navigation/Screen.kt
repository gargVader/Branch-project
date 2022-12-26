package com.example.branch_project.presentation.navigation

const val NAV_GRAPH_ROOT = "root_graph"
const val NAV_GRAPH_HOME = "home_graph"

const val ARG_CHAT_THREAD_ID = "threadId"

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object HomeScreen : Screen("home")
    object ChatScreen : Screen("chat")
}
