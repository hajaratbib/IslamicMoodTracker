package com.example.compose.screens

import android.content.Context
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.compose.UserPreferences
import com.example.compose.composables.DhikrTitleCard
import kotlinx.coroutines.launch

@Composable
fun DhikrScreen(
    context: Context,
    navController: NavController
) {
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            DhikrTitleCard(
                title = "Morning Dhikr",
                icon = Icons.Default.WbSunny,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "morning")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Night Dhikr",
                icon = Icons.Default.Nightlight,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "night")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Wake up Dhikr",
                icon = Icons.Default.WbSunny,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "wake")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Sleep Dhikr",
                icon = Icons.Default.SingleBed,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "Sleep")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Mosque Dhikr",
                icon = Icons.Default.Mosque,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "Mosque")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "After Salat Dhikr",
                icon = Icons.Default.Mosque,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "Salat")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Ablution Dhikr",
                icon = Icons.Default.Wash,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "Ablution")
                        navController.navigate("Adhkar")

                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "Bathroom Dhikr",
                icon = Icons.Default.Bathroom,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "bathroom")
                        navController.navigate("Adhkar")
                    }
                })
            Spacer(Modifier.height(16.dp))
        }

        item {
            DhikrTitleCard(
                title = "House Dhikr",
                icon = Icons.Default.House,
                onClick = {
                    scope.launch {
                        UserPreferences.saveDhikrType(context, "house")
                        navController.navigate("Adhkar")
                    }
                })
        }
    }
}