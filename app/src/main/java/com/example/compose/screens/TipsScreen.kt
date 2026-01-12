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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.compose.R
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
            title = R.string.breathing_title,
            description = R.string.breathing_desc,
            icon = Icons.Default.Favorite,
            colorResource(R.color.light_red),
            onClick = onNavigateToBreathing
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = R.string.wellbeing_title,
            description = R.string.wellbeing_desc,
            icon = Icons.Default.Lightbulb,
            colorResource(R.color.yellow),
            onClick = onNavigateToDailyTips
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = R.string.gratitude_title,
            description = R.string.gratitude_desc,
            icon = Icons.Default.Spa,
            colorResource(R.color.light_green),
            onClick = onNavigateToGratitudePractice
        )

        Spacer(Modifier.height(16.dp))

        FeatureCard(
            title = R.string.journaling_title,
            description = R.string.journaling_desc,
            icon = Icons.Default.Edit,
            colorResource(R.color.dark_gray),
            onClick = onNavigateToJournaling
        )
    }

}