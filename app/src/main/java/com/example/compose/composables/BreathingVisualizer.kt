package com.example.compose.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.BreathAction

@Composable
fun BreathingVisualizer(
    action: BreathAction,
    sessionProgress: Float
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(220.dp)
    ) {
        CircularSessionProgress(
            progress = sessionProgress,
            modifier = Modifier.fillMaxSize()
        )

        BreathingCircle(
            action = action
        )
    }
}
