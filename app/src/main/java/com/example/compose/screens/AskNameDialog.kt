package com.example.compose.screens

import android.content.Context
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import com.example.compose.UserPreferences
import kotlinx.coroutines.launch

@Composable
fun AskNameDialog(
    context: Context,
    onNameSaved: (String) -> Unit
) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()

    AlertDialog(
        onDismissRequest = {},
        title = { Text("Welcome! What is your name?") },
        text = {
            TextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Enter your name") }
            )
        },
        confirmButton = {
            Button(onClick = {
                if (name.text.isNotBlank()) {
                    scope.launch {
                        UserPreferences.saveName(context, name.text.trim())
                        onNameSaved(name.text.trim())
                    }
                }
            }) {
                Text("Save")
            }
        }
    )
}
