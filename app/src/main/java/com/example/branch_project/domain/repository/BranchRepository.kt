package com.example.branch_project.domain.repository

import com.example.branch_project.domain.model.Message
import com.example.branch_project.util.Resource
import kotlinx.coroutines.flow.Flow

interface BranchRepository {

    var messageList: Map<Int, List<Message>>?

    suspend fun login(
        email: String,
        password: String
    ): Flow<Resource<String>>

    suspend fun getAllMessages(
        authToken: String
    ): Flow<Resource<Map<Int, List<Message>>>>

    suspend fun sendMessage(
        authToken: String,
        threadId: Int,
        body: String,
    ): Flow<Resource<Message>>

    suspend fun reset(
        authToken: String,
    )

}