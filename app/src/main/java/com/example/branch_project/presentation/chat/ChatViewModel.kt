package com.example.branch_project.presentation.chat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.branch_project.domain.repository.BranchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    repository: BranchRepository
) : ViewModel() {

    var state by mutableStateOf(ChatState())

    init {
//        state.messageList = repository.messageList!!
    }

}