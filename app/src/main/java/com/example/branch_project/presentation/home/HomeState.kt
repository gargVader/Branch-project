package com.example.branch_project.presentation.home

import com.example.branch_project.domain.model.Message

data class HomeState(
    val messageMap: Map<Int, List<Message>> = emptyMap(),
    val isLoading: Boolean = false,
    val isRefreshing : Boolean = false,
)