package com.example.compose.composables

import com.example.compose.R

data class OnboardingPage(
    val title: Int,
    val icon: String,
    val description: Int,
    val animationRes: Int
)

val onboardingPages = listOf(
    OnboardingPage(
        title = R.string.Onboarding_title1,
        icon = " 🌿",
        description = R.string.Onboarding_message1,
        animationRes = R.drawable.sukoon
    ),
    OnboardingPage(
        title = R.string.Onboarding_title2,
        icon = "\uD83D\uDD4A\uFE0F",
        description = R.string.Onboarding_message2,
        animationRes = R.drawable.breathing
    ),
    OnboardingPage(
        title = R.string.Onboarding_title3,
        icon = "\uD83D\uDCFF",
        description = R.string.Onboarding_message3,
        animationRes = R.drawable.dhikr_beads
    )
)