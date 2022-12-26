package com.example.branch_project.presentation.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ChatScreen(
    navController: NavHostController,
    threadId: Int,
    viewModel: ChatViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val messageList = state.messageMap[threadId]?.sortedBy {
        it.timestamp
    }

    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            messageList?.let {
                items(messageList) { message ->
                    MessageItem(message = message)
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth(),
        ) {

            OutlinedTextField(
                value = state.text,
                onValueChange = {
                    viewModel.state = state.copy(text = it)
                },
                placeholder = { Text(text = "Enter message") },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                trailingIcon = {
                    if (state.isBeingSent) {
                        CircularProgressIndicator()
                    } else {
                        IconButton(
                            onClick = {
                                viewModel.sendMessage(
                                    threadId = threadId,
                                    body = state.text
                                )
                            }) {
                            Icon(Icons.Filled.Send, contentDescription = null)
                        }

                    }
                }
            )
        }
    }
}