package com.example.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.composables.FeatureCard

@Composable
fun TipsScreen(
    onNavigateToBreathing: () -> Unit = {},
    onNavigateToDailyTips: () -> Unit = {},
    onNavigateToDhikr: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        FeatureCard(
            title = "Breathing Exercise",
            description = "Relax with guided breathing",
            icon = Icons.Default.Favorite,
            onClick = onNavigateToBreathing
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = "Daily Wellbeing Tips",
            description = "Personalized advice for your mood",
            icon = Icons.Default.Lightbulb,
            onClick = onNavigateToDailyTips
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = "Dhikr & Spiritual Calm",
            description = "Authentic adhkar for peace",
            icon = Icons.Default.Spa,
            onClick = onNavigateToDhikr
        )
    }

}