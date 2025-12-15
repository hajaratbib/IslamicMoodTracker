package com.example.compose.composables

import com.example.compose.R

data class OnboardingPage(
    val title: String,
    val description: String,
    val animationRes: Int
)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Welcome to Sukoon 🌿",
        description = "Track your mood and discover emotional clarity.",
        animationRes = R.drawable.sukoon
    ),
    OnboardingPage(
        title = "Breathe & Relax \uD83D\uDD4A\uFE0F",
        description = "Guided breathing exercises to reduce anxiety and stress.",
        animationRes = R.drawable.breathing
    ),
    OnboardingPage(
        title = "Find Inner Peace \uD83D\uDC8E",
        description = "Get daily dhikr and reminders for spiritual calm.",
        animationRes = R.drawable.dhikr_beads
    )
)