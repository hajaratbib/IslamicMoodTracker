package com.example.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.BreathingPattern
import kotlinx.coroutines.delay

@Composable
fun BreathingPlayerScreen(
    modifier: Modifier = Modifier,
    pattern: BreathingPattern,
    totalCycles: Int = 5
) {
    var stepIndex by remember { mutableIntStateOf(0) }
    var secondsRemaining by remember { mutableIntStateOf(pattern.steps[0].durationSeconds) }
    var completedCycles by remember { mutableIntStateOf(0) }
    var isRunning by remember { mutableStateOf(true) }

    val currentStep = pattern.steps[stepIndex]

    LaunchedEffect(stepIndex, secondsRemaining, isRunning) {
        if (!isRunning || completedCycles >= totalCycles) return@LaunchedEffect

        if (secondsRemaining > 0) {
            delay(1000)
            secondsRemaining--
        } else {
            val nextStepIndex = stepIndex + 1

            if (nextStepIndex >= pattern.steps.size) {
                // Completed one full cycle
                completedCycles++
                stepIndex = 0
            } else {
                stepIndex = nextStepIndex
            }

            secondsRemaining = pattern.steps[stepIndex].durationSeconds
        }
    }

    val progress = completedCycles / totalCycles.toFloat()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = pattern.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = pattern.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔄 Cycle Progress Indicator
            LinearProgressIndicator(
                progress = { progress.coerceIn(0f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Cycle ${completedCycles.coerceAtMost(totalCycles)} of $totalCycles",
                style = MaterialTheme.typography.labelMedium
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = currentStep.label,
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "$secondsRemaining",
                style = MaterialTheme.typography.displayLarge
            )

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(onClick = { isRunning = !isRunning }) {
                    Text(if (isRunning) "Pause" else "Resume")
                }

                OutlinedButton(
                    onClick = {
                        stepIndex = 0
                        secondsRemaining = pattern.steps[0].durationSeconds
                        completedCycles = 0
                        isRunning = false
                    }
                ) {
                    Text("Reset")
                }
            }
        }
    }
}
