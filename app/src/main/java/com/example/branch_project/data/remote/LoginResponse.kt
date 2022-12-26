package com.example.branch_project.data.remote

import com.squareup.moshi.Json

data class LoginResponse(
    @field:Json(name = "auth_token")
    val authToken: String
)