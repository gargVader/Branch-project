package com.example.branch_project.presentation.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {

    Column() {
        OutlinedTextField(
            value = viewModel.state.email,
            onValueChange = {
                viewModel.state.email = it
            })

        OutlinedTextField(
            value = viewModel.state.password,
            onValueChange = {
                viewModel.state.password = it
            })

        Button(
            onClick = {
                viewModel.onEvent(
                    LoginEvent.OnLoginClick(
                        viewModel.state.email,
                        viewModel.state.password
                    )
                )
            }) {
            Text(text = "Login")
        }
    }

}