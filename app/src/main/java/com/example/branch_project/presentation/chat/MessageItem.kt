package com.example.branch_project.presentation.chat


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.branch_project.domain.model.Message
import com.example.branch_project.ui.theme.LightGreen
import com.example.branch_project.ui.theme.LightYellow

@Composable
fun MessageItem(message: Message) {
    val isSelf: Boolean = (message.agentId != null)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = if (isSelf) Alignment.End else Alignment.Start
    ) {


        BoxWithConstraints {
            Box(
                modifier = Modifier
                    .background(
                        color = if (isSelf) LightYellow else LightGreen,
                        shape = if (isSelf) RoundedCornerShape(8.dp, 0.dp, 8.dp, 8.dp)
                        else RoundedCornerShape(0.dp, 8.dp, 8.dp, 8.dp)
                    )
                    .widthIn(max = maxWidth * 0.8f, min = 0.dp)
                    .padding(4.dp),
            ) {
                Column() {
                    Text(
                        text = (if (isSelf) message.agentId else message.userId)!!
                    )
                    Text(text = message.body)
                }

            }
        }


    }

}