package com.example.branch_project.presentation.chat

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ChatScreen(
    navController: NavHostController,
    threadId: Int,
    viewModel: ChatViewModel = hiltViewModel()
) {

    Text(text = "$threadId")

}