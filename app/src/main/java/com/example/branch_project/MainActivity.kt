package com.example.branch_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.branch_project.presentation.navigation.RootNavGraph
import com.example.branch_project.ui.theme.BranchProjectTheme
import com.example.branch_project.util.AgentPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BranchProjectTheme {
                val navController = rememberNavController()
                RootNavGraph(navController = navController)
            }

        }
    }
}