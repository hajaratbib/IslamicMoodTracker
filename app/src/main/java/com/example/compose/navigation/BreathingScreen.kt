package com.example.compose.navigation

sealed class BreathingScreen(val route: String) {
    object BreathingList : BreathingScreen("breathing_list")
    object BreathingPlayer : BreathingScreen("breathing_player/{patternName}") {
        fun createRoute(patternName: String) = "breathing_player/$patternName"
    }
}
