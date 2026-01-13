package com.example.compose.composables

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularSessionProgress(
    progress: Float,
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        progress = progress.coerceIn(0f, 1f),
        strokeWidth = 6.dp,
        modifier = modifier
    )
}
