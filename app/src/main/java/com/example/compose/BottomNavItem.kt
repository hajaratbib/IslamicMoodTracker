package com.example.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Spa
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Tips : BottomNavItem("tips", "Tips", Icons.Default.Lightbulb)
    object Dhikr : BottomNavItem("dhikr", "Dhikr", Icons.Default.Spa)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}