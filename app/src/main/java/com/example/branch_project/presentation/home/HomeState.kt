package com.example.branch_project.presentation.home

import com.example.branch_project.domain.model.Message

data class HomeState(
    val messageList : List<Message> = emptyList(),
    val isLoading : Boolean = false,
)