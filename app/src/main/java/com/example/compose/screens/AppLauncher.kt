package com.example.compose.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.compose.UserPreferences
import com.example.compose.composables.LottieOnboarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AppLauncher(context: Context) {

    val onboardingDone =
        UserPreferences.isOnboardingCompleted(context)
            .collectAsState(initial = null)

    when (onboardingDone.value) {

        null -> LoadingScreen()

        false -> LottieOnboarding(
            onFinish = {
                CoroutineScope(Dispatchers.IO).launch {
                    UserPreferences.setOnboardingCompleted(context)
                }
            }
        )

        true -> NavigationScreen(context)
    }
}
