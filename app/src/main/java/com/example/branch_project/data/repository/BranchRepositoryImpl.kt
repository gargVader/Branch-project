package com.example.branch_project.data.repository

import com.example.branch_project.data.remote.BranchApi
import com.example.branch_project.data.remote.LoginRequest
import com.example.branch_project.data.remote.MessageRequest
import com.example.branch_project.domain.model.Message
import com.example.branch_project.domain.repository.BranchRepository
import com.example.branch_project.util.AgentPreferences
import com.example.branch_project.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BranchRepositoryImpl @Inject constructor(
    private val api: BranchApi,
    private val agentPreferences: AgentPreferences,
) : BranchRepository {

    override suspend fun login(email: String, password: String): Flow<Resource<String>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val response =
                try {
                    api.login(LoginRequest(username = email, password = password))
                } catch (e: Exception) {
                    e.printStackTrace()
                    emit(Resource.Error("Error"))
                    null
                }

            response?.let {
                agentPreferences.saveAuthToken(it.authToken)
                emit(Resource.Success(data = it.authToken))
                emit(Resource.Loading(isLoading = false))
            }
        }
    }

    override suspend fun getAllMessages(authToken: String): Flow<Resource<List<Message>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val response = try {
                api.getAllMessages(authToken = authToken)
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error("Error"))
                null
            }

            response?.let {
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
        }
    }

    override suspend fun sendMessage(
        authToken: String,
        threadId: Int,
        body: String
    ): Flow<Resource<Message>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val response = try {
                api.sendMessage(
                    authToken = authToken,
                    MessageRequest(threadId = threadId, body = body)
                )
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error("Error"))
                null
            }

            response?.let {
                emit(Resource.Success(data = response))
                emit(Resource.Loading(isLoading = false))
            }
        }
    }

    override suspend fun reset(authToken: String) {
        api.reset(authToken = authToken)
    }
}