package com.example.compose.screens

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bathroom
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Mosque
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.SingleBed
import androidx.compose.material.icons.filled.Wash
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.DhikrType
import com.example.compose.UserPreferences
import com.example.compose.composables.DhikrTitleCard
import kotlinx.coroutines.launch

@Composable
fun DhikrScreen(
    context: Context,
    navController: NavController
) {
    val items = listOf(
        DhikrType("Morning Dhikr", Icons.Default.WbSunny, "morning"),
        DhikrType("Night Dhikr", Icons.Default.Nightlight, "night"),
        DhikrType("Wake up Dhikr", Icons.Default.WbSunny, "wake"),
        DhikrType("Sleep Dhikr", Icons.Default.SingleBed, "sleep"),
        DhikrType("Mosque Dhikr", Icons.Default.Mosque, "mosque"),
        DhikrType("After Salat Dhikr", Icons.Default.Mosque, "salat"),
        DhikrType("Ablution Dhikr", Icons.Default.Wash, "ablution"),
        DhikrType("Bathroom Dhikr", Icons.Default.Bathroom, "bathroom"),
        DhikrType("House Dhikr", Icons.Default.House, "house"),
    )
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        items(items) { item ->
            DhikrTitleCard(
                title = item.title,
                icon = item.icon,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, item.type)
                        navController.navigate("Adhkar")
                    }
                }
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}