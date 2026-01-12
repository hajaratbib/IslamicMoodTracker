package com.example.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Spa
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: Int,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", R.string.home, Icons.Default.Home)
    object Tips : BottomNavItem("tips", R.string.tips, Icons.Default.Lightbulb)
    object Dhikr : BottomNavItem("dhikr", R.string.dhikr, Icons.Default.Spa)
    object Profile : BottomNavItem("profile", R.string.profile, Icons.Default.Person)
}