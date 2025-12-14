package com.example.compose.screens

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.BottomNavItem
import com.example.compose.composables.BottomNavigationBar
import com.example.compose.composables.HomeTopBar

@Composable
fun NavigationScreen(context: Context) {


    val navController = rememberNavController()

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

            composable(BottomNavItem.Home.route) { HomeScreen() }

            composable(BottomNavItem.Tips.route) { TipsScreen() }

            composable(BottomNavItem.Dhikr.route) { HomeScreen() }

            composable(BottomNavItem.Profile.route) { HomeScreen() }

            composable("settings") { HomeScreen() }
        }
    }
}