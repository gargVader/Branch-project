package com.example.branch_project.util

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// Used to store auth token of logged in customer service agent

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")

@Singleton
class AgentPreferences @Inject constructor(val app: Application) {

    suspend fun getAuthToken(): String? {
        return app.dataStore.data.first()[BRANCH_AUTH_TOKEN]
    }

    suspend fun saveAuthToken(authToken: String) {
        app.dataStore.edit { preferences ->
            preferences[BRANCH_AUTH_TOKEN] = authToken
        }
    }

    suspend fun clear() {
        app.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val BRANCH_AUTH_TOKEN = stringPreferencesKey("branch_auth_token")
    }

}