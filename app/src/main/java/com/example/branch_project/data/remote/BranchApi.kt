package com.example.branch_project.data.remote

import com.example.branch_project.domain.model.Message
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface BranchApi {

    @POST("api/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse

    @GET("api/messages")
    suspend fun getAllMessages(
        @Header("X-Branch-Auth-Token") authToken: String,
    ): List<MessageDto>

    @POST("api/messages")
    suspend fun sendMessage(
        @Header("X-Branch-Auth-Token") authToken: String,
        @Body messageRequest: MessageRequest
    ): MessageDto

    @POST("api/reset")
    suspend fun reset(
        @Header("X-Branch-Auth-Token") authToken: String,
    )

    companion object {
        const val BASE_URL = "https://android-messaging.branch.co/"
    }

}