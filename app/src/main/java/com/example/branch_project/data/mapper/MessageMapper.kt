package com.example.branch_project.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.branch_project.data.remote.MessageDto
import com.example.branch_project.domain.model.Message
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun MessageDto.toMessage(): Message {
    val pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timestamp, formatter)
    return Message(
        id = id,
        threadId = threadId,
        userId = userId,
        agentId = agentId,
        body = body,
        timestamp = localDateTime,
    )
}