package com.example.branch_project.presentation.home

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.branch_project.presentation.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state



//    Button(onClick = { navController.navigate(Screen.ChatScreen.route + "/" + "1") }) {
//        Text(text = "Click")
//    }


}