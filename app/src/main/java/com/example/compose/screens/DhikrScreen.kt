package com.example.compose.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bathroom
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Mosque
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.SingleBed
import androidx.compose.material.icons.filled.Wash
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.composables.DhikrTitleCard

@Composable
fun DhikrScreen(
    onNavigateToBreathing: () -> Unit = {},
    onNavigateToDailyTips: () -> Unit = {},
    onNavigateToGratitudePractice: () -> Unit = {},
    onNavigateToJournaling: () -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            DhikrTitleCard(
                title = "Morning Dhikr",
                icon = Icons.Default.WbSunny,
                onClick = onNavigateToBreathing
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Night Dhikr",
                icon = Icons.Default.Nightlight,
                onClick = onNavigateToDailyTips
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Wake up Dhikr",
                icon = Icons.Default.WbSunny,
                onClick = onNavigateToGratitudePractice
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Sleep Dhikr",
                icon = Icons.Default.SingleBed,
                onClick = onNavigateToJournaling
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Mosque Dhikr",
                icon = Icons.Default.Mosque,
                onClick = onNavigateToJournaling
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "After Salat Dhikr",
                icon = Icons.Default.Mosque,
                onClick = onNavigateToJournaling
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Ablution Dhikr",
                icon = Icons.Default.Wash,
                onClick = onNavigateToJournaling
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Bathroom Dhikr",
                icon = Icons.Default.Bathroom,
                onClick = onNavigateToJournaling
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "House Dhikr",
                icon = Icons.Default.House,
                onClick = onNavigateToJournaling
            )
        }
    }
}