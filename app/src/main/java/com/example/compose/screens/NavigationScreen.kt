package com.example.compose.screens

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.BottomNavItem
import com.example.compose.UserPreferences
import com.example.compose.composables.BottomNavigationBar
import com.example.compose.composables.HomeTopBar

@Composable
fun NavigationScreen(context: Context) {


    val navController = rememberNavController()
    val nameFlow = UserPreferences.getName(context).collectAsState(initial = null)

    Scaffold(
        topBar = {
            HomeTopBar(onSettingsClick = {
                // Navigate to settings screen
                navController.navigate("settings")
            })
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "start",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("start") { StartScreen(context = context) }

            composable(BottomNavItem.Home.route) { HomeScreen(context, nameFlow.value?:"") }

            composable(BottomNavItem.Tips.route) { TipsScreen() }

            composable(BottomNavItem.Dhikr.route) { DhikrScreen() }

            composable(BottomNavItem.Profile.route) { ProfileScreen() }

            composable("settings") { SettingsScreen() }
        }
    }
}