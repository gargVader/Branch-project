package com.example.branch_project.presentation.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.branch_project.domain.repository.BranchRepository
import com.example.branch_project.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: BranchRepository
) : ViewModel() {

    var state by mutableStateOf(LoginState())

    fun login(
        email: String = state.email,
        password: String = state.password,
        onLoginSuccess: () -> Unit,
        onError : () -> Unit
    ) {
        viewModelScope.launch {
            repository.login(
                email = state.email,
                password = state.password
            ).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data != null) {
                            onLoginSuccess()
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(isLoggingIn = result.isLoading)
                    }

                    is Resource.Error -> {
                        onError()
                    }
                }
            }
        }
    }
}