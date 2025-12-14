package com.example.compose.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MoodRow(onMoodSelected: (String) -> Unit) {
    val moods = listOf(
        "Happy",
        "Calm",
        "Sad",
        "Anxious",
        "Angry",
        "Tired",
        "Stressed",
        "Lonely",
        "Guilty",
        "Confused",
        "Hopeful",
        "Fearful",
        "Grateful",
        "Excited",
        "Jealous",
        "Overwhelmed",
        "Peaceful",
        "Motivated",
        "Regretful",
        "Frustrated",
        "Lonely/isolated",
        "Overjoyed",
        "Insecure",
        "Nostalgic",
        "Confident",
        "Embarrassed",
        "Relaxed",
        "Curious",
    )
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()) // scroll vertically if needed
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        itemVerticalAlignment = Alignment.Top,
        maxItemsInEachRow = Int.MAX_VALUE, // wrap based on space
    ) {
        moods.forEach { mood ->
            MoodChip(mood = mood, onClick = { onMoodSelected(mood) })
        }
    }
}
