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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.compose.R

@Composable
fun MoodRow(onMoodSelected: (Int) -> Unit) {
    val moods = listOf(
        R.string.happy,
        R.string.calm,
        R.string.sad,
        R.string.anxious,
        R.string.angry,
        R.string.tired,
        R.string.stressed,
        R.string.lonely,
        R.string.guilty,
        R.string.confused,
        R.string.hopeful,
        R.string.fearful,
        R.string.grateful,
        R.string.excited,
        R.string.jealous,
        R.string.overwhelmed,
        R.string.peaceful,
        R.string.motivated,
        R.string.regretful,
        R.string.frustrated,
        R.string.overjoyed,
        R.string.insecure,
        R.string.nostalgic,
        R.string.confident,
        R.string.embarrassed,
        R.string.relaxed,
        R.string.curious,
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
            MoodChip(mood = stringResource(mood), onClick = { onMoodSelected(mood) })
        }
    }
}
