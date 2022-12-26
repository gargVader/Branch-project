package com.example.branch_project.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.branch_project.presentation.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val state = viewModel.state

    state.messageMap.toSortedMap()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.messageMap.toSortedMap().toList()) { item ->
            val threadId = item.first
            val message = item.second.sortedBy {
                it.timestamp
            }.last()
            ThreadItem(
                body = message.body,
                timestamp = message.timestamp,
                id = message.userId,
                modifier = Modifier.clickable(enabled = true){
                    navController.navigate(Screen.ChatScreen.route + "/" + "$threadId")
                }
            )


//            item.second.

        }
    }


//    Button(onClick = { navController.navigate(Screen.ChatScreen.route + "/" + "1") }) {
//        Text(text = "Click")
//    }


}