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

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLoginClick -> {
                login()
            }
        }
    }

    private fun login(
        email: String = state.email,
        password: String = state.password
    ) {
        viewModelScope.launch {
            repository.login(
                email = state.email,
                password = state.password
            ).collect { result ->
                when(result){
                    is Resource.Success -> {
                        if (result.data!=null){
                            // login success
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(isLoggingIn = true)
                    }

                    is Resource.Error -> {

                    }
                }
            }
        }
    }

}