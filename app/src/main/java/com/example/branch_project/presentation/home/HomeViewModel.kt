package com.example.branch_project.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.branch_project.domain.repository.BranchRepository
import com.example.branch_project.util.AgentPreferences
import com.example.branch_project.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: BranchRepository,
    val agentPreferences: AgentPreferences,
) : ViewModel() {

    var state by mutableStateOf(HomeState())

    init {
        fetchAllMessages()
    }

    fun fetchAllMessages() {
        viewModelScope.launch {
            val authToken = agentPreferences.getAuthToken()
            if (authToken != null) {
                repository.getAllMessages(authToken = authToken).collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            if (result.data != null) {
                                state = state.copy(messageList = result.data)
                            }
                        }

                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }

                        is Resource.Error -> {

                        }
                    }
                }
            }
        }
    }

}