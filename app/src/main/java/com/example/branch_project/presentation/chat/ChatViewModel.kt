package com.example.branch_project.presentation.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.branch_project.domain.model.Message
import com.example.branch_project.domain.repository.BranchRepository
import com.example.branch_project.util.AgentPreferences
import com.example.branch_project.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    val repository: BranchRepository,
    val agentPreferences: AgentPreferences,
) : ViewModel() {

    var state by mutableStateOf(ChatState())

    init {
        state = state.copy(messageMap = repository.messageMap!!)
    }

    fun sendMessage(threadId: Int, body: String) {
        viewModelScope.launch {
            val authToken = agentPreferences.getAuthToken()
            if (authToken != null) {

                repository.sendMessage(
                    authToken = authToken,
                    threadId = threadId,
                    body = body
                ).collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            if (result.data != null) {
                                val updatedMap = state.messageMap +
                                        (threadId to state.messageMap[threadId]?.plus(result.data))
                                state =
                                    state.copy(messageMap = updatedMap as Map<Int, List<Message>>, text = "")

                            }
                        }

                        is Resource.Loading -> {
                            state = state.copy(isBeingSent = result.isLoading)
                        }

                        is Resource.Error -> {

                        }
                    }
                }
            }
        }
    }

}