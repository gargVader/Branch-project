package com.example.branch_project.data.remote

import com.squareup.moshi.Json

data class MessageRequest(
    @field:Json(name = "thread_id")
    val threadId: Int,
    @field:Json(name = "body")
    val body: String,
)