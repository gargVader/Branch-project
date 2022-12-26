package com.example.branch_project.domain.model

import java.time.LocalDateTime


data class Message(
    val id: Int,
    val threadId: Int,
    val userId: String,
    val agentId: String?,
    val body: String,
    val timestamp: LocalDateTime,
)