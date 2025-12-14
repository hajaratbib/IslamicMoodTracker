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
        animationRes = R.raw.welcome_leaf
    ),
    OnboardingPage(
        title = "Breathe & Relax",
        description = "Guided breathing exercises to reduce anxiety and stress.",
        animationRes = R.raw.breathing_ring
    ),
    OnboardingPage(
        title = "Find Inner Peace",
        description = "Get daily dhikr and reminders for spiritual calm.",
        animationRes = R.raw.dhikr_beads
    )
)