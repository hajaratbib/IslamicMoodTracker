package com.example.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.breathingPatterns
import com.example.compose.composables.BreathingCard
import com.example.compose.navigation.BreathingScreen

@Composable
fun BreathingListScreen(
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(breathingPatterns) { pattern ->
            BreathingCard(
                pattern = pattern,
                onClick = {
                    navController.navigate(
                        BreathingScreen.BreathingPlayer.createRoute(pattern.name)
                    )
                }
            )
        }
    }
}
