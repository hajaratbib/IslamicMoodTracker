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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose.DhikrType
import com.example.compose.R
import com.example.compose.UserPreferences
import com.example.compose.composables.DhikrTitleCard
import kotlinx.coroutines.launch

@Composable
fun DhikrScreen(
    context: Context,
    navController: NavController
) {
    val items = listOf(
        DhikrType(
            stringResource(R.string.morning_dhikr),
            Icons.Default.WbSunny,
            colorResource(R.color.yellow),
            "morning"
        ),
        DhikrType(
            stringResource(R.string.night_dhikr),
            Icons.Default.Nightlight,
            colorResource(R.color.dark_gray),
            "night"
        ),
        DhikrType(
            stringResource(R.string.wake_up_dhikr),
            Icons.Default.WbSunny,
            colorResource(R.color.yellow),
            "wake"
        ),
        DhikrType(
            stringResource(R.string.sleep_dhikr),
            Icons.Default.SingleBed,
            colorResource(R.color.dark_gray),
            "Sleep"
        ),
        DhikrType(
            stringResource(R.string.mosque_dhikr),
            Icons.Default.Mosque,
            colorResource(R.color.cream),
            "Mosque"
        ),
        DhikrType(
            stringResource(R.string.after_salat_dhikr),
            Icons.Default.Mosque,
            colorResource(R.color.light_gray),
            "Salat"
        ),
        DhikrType(
            stringResource(R.string.ablution_dhikr),
            Icons.Default.Wash,
            colorResource(R.color.teal_700),
            "Ablution"
        ),
        DhikrType(
            stringResource(R.string.bathroom_dhikr),
            Icons.Default.Bathroom,
            colorResource(R.color.gray),
            "bathroom"
        ),
        DhikrType(
            stringResource(R.string.house_dhikr),
            Icons.Default.House,
            colorResource(R.color.brown),
            "house"
        ),
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
                iconColor = item.iconColor,
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