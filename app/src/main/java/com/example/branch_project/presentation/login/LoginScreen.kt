package com.example.branch_project.presentation.login

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.branch_project.presentation.navigation.Screen

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val state = viewModel.state
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        OutlinedTextField(
            value = viewModel.state.email,
            label = { Text(text = "Email") },
            onValueChange = {
                viewModel.state = state.copy(email = it)
            })

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
        )

        OutlinedTextField(
            value = viewModel.state.password,
            label = { Text(text = "Password") },
            onValueChange = {
                viewModel.state = state.copy(password = it)
            })

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
        )

        Button(
            onClick = {
                viewModel.login(
                    onLoginSuccess = { navController.navigate(Screen.HomeScreen.route) },
                    onError = {
                        Log.d("BranchApp", "LoginScreen: $it")
                    })
            }) {
            Text(text = "Login")
        }
        if (viewModel.state.isLoggingIn) {
            CircularProgressIndicator()
        }
    }

}