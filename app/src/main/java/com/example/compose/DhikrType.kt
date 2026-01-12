package com.example.compose

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


data class DhikrType(
    val title: String,
    val icon: ImageVector,
    val iconColor: Color,
    val type: String
)