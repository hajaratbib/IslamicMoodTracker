package com.example.compose.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.compose.BottomNavItem
import com.example.compose.UserPreferences
import com.example.compose.breathingPatterns
import com.example.compose.composables.BottomNavigationBar
import com.example.compose.composables.HomeTopBar
import com.example.compose.screens.AdhkarScreen
import com.example.compose.screens.BreathingListScreen
import com.example.compose.screens.BreathingPlayerScreen
import com.example.compose.screens.DhikrScreen
import com.example.compose.screens.HomeScreen
import com.example.compose.screens.ProfileScreen
import com.example.compose.screens.SettingsScreen
import com.example.compose.screens.StartScreen
import com.example.compose.screens.TipsScreen

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

            composable(BottomNavItem.Home.route) { HomeScreen(context, nameFlow.value ?: "") }

            composable(BottomNavItem.Tips.route) { TipsScreen(navController) }

            composable(BottomNavItem.Dhikr.route) {
                DhikrScreen(
                    context = context,
                    navController = navController
                )
            }

            composable(BottomNavItem.Profile.route) { ProfileScreen() }

            composable("Adhkar") { AdhkarScreen(context) }

            composable("settings") { SettingsScreen() }

            composable(BreathingScreen.BreathingList.route) {
                BreathingListScreen(navController)
            }

            composable(
                route = BreathingScreen.BreathingPlayer.route,
                arguments = listOf(
                    navArgument("patternName") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val patternName =
                    backStackEntry.arguments?.getString("patternName")

                val pattern = breathingPatterns.first {
                    it.name == patternName
                }

                BreathingPlayerScreen(
                    pattern = pattern,
                    totalCycles = 5
                )
            }
        }
    }
}