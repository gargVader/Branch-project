package com.example.branch_project.presentation.chat

import com.example.branch_project.domain.model.Message

data class ChatState(
    var messageList: Map<Int, List<Message>> = emptyMap()
)