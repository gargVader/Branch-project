package com.example.branch_project.data.repository

import android.util.Log
import androidx.lifecycle.Observer
import com.example.branch_project.data.remote.BranchApi
import com.example.branch_project.data.remote.LoginRequest
import com.example.branch_project.domain.model.Message
import com.example.branch_project.domain.repository.BranchRepository
import com.example.branch_project.util.AgentPreferences
import com.example.branch_project.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
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
                } catch (e: IOException) {
                    e.printStackTrace()
                    emit(Resource.Error("Error"))
                    null
                } catch (e: HttpException) {
                    e.printStackTrace()
                    emit(Resource.Error("Error"))
                    null
                }

            response?.let {
                agentPreferences.saveAuthToken(it.authToken)
                Log.d("Girish", "from req login: ${it.authToken}")
                Log.d("Girish", "login: ${agentPreferences.getAuthToken()}")
                emit(Resource.Success(data = it.authToken))
                emit(Resource.Loading(isLoading = false))
            }
        }
    }

    override suspend fun getAllMessages(authToken: String): Flow<Resource<List<Message>>> {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(
        authToken: String,
        threadId: Int,
        body: String
    ): Flow<Resource<Message>> {
        TODO("Not yet implemented")
    }

    override suspend fun reset(authToken: String) {
        TODO("Not yet implemented")
    }
}