package com.example.compose.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.example.compose.BreathAction

@Composable
fun BreathingCircle(
    action: BreathAction,
    modifier: Modifier = Modifier
) {
    val targetScale = when (action) {
        BreathAction.INHALE -> 1.2f
        BreathAction.EXHALE -> 0.8f
        BreathAction.HOLD -> 1.0f
    }

    val scale by animateFloatAsState(
        targetValue = targetScale,
        animationSpec = tween(durationMillis = 1000),
        label = "breathing-scale"
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(160.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .background(
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f),
                    shape = CircleShape
                )
        )
    }
}