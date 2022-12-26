package com.example.branch_project.presentation.chat

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.branch_project.presentation.home.HomeViewModel

@Composable
fun ChatScreen(
    navController: NavHostController,
    threadId: Int,
    viewModel: HomeViewModel = hiltViewModel()
) {

}