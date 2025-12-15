package com.example.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
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
    onNavigateToGratitudePractice: () -> Unit = {},
    onNavigateToJournaling: () -> Unit = {}
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
            title = "Daily Wellbeing habits",
            description = "Practices for a better life style",
            icon = Icons.Default.Lightbulb,
            onClick = onNavigateToDailyTips
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = "Gratitude Practice",
            description = "Shift focus on the blessings",
            icon = Icons.Default.Spa,
            onClick = onNavigateToGratitudePractice
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = "Journaling",
            description = "Process emotions by writing thoughts",
            icon = Icons.Default.Edit,
            onClick = onNavigateToJournaling
        )
    }

}