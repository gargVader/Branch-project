package com.example.branch_project.data.remote

import com.squareup.moshi.Json

data class MessageDto(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "thread_id")
    val threadId: Int,
    @field:Json(name = "user_id")
    val userId: String,
    @field:Json(name = "agent_id")
    val agentId: String?,
    @field:Json(name = "body")
    val body: String,
    @field:Json(name = "timestamp")
    val timestamp: String
)