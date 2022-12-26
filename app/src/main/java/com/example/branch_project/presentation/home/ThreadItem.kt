package com.example.branch_project.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ThreadItem(
    body: String,
    timestamp: LocalDateTime,
    id: String,
    modifier: Modifier
) {
    Column(modifier = modifier.padding(horizontal = 8.dp).fillMaxWidth()) {
        Text(
            text = timestamp.format(DateTimeFormatter.ofPattern("MMM d yyy, h:mm a")),
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(text = id)
        Text(text = body, modifier = Modifier.padding(bottom = 8.dp))
        Divider(thickness = 4.dp)
    }
}