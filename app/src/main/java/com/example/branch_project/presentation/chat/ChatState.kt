package com.example.branch_project.presentation.chat

import com.example.branch_project.domain.model.Message

data class ChatState(
    val messageMap: Map<Int, List<Message>> = emptyMap(),
    val text: String = "",
    val messageSent: Message? = null,
    val isBeingSent: Boolean = false,
)