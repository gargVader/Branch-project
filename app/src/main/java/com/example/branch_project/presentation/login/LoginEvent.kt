package com.example.branch_project.presentation.login

sealed class LoginEvent {
    data class OnLoginClick(val email: String, val password: String) : LoginEvent()
}