package com.example.compose.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.compose.UserPreferences

@Composable
fun StartScreen(context: Context) {

    val nameFlow = UserPreferences.getName(context).collectAsState(initial = null)
    when (val username = nameFlow.value) {
        null -> {
            // Don't show the dialog yet — wait until DataStore finishes loading
            // Show a loading UI instead
            LoadingScreen()
        }

        "" -> {
            // No name saved yet → show dialog
            AskNameDialog(context) { savedName ->
                // nothing else needed — DataStore will recompose
            }
        }

        else -> {
            // Name exists → show the actual home screen
            HomeScreen(context = context, username = username)
        }
    }
}