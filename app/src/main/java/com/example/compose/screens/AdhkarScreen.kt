package com.example.compose.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.Adhkar
import com.example.compose.DhikrUi
import com.example.compose.UserPreferences
import com.example.compose.composables.DhikrItem

@Composable
fun AdhkarScreen(context: Context) {

    val state = UserPreferences.getDhikrType(context).collectAsState(initial = null)


    when (val type = state.value) {
        null -> {
            // Don't show the dialog yet — wait until DataStore finishes loading
            // Show a loading UI instead
            LoadingScreen()
        }

        else -> {
            val adhkar = remember {
                mutableStateListOf<DhikrUi>().apply {
                    addAll(
                        Adhkar.filter { it.type == type }.mapIndexed { index, dhikr ->
                            DhikrUi(
                                id = index,
                                text = dhikr.text,
                                remaining = dhikr.initialCount
                            )
                        }
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(
                    items = adhkar,
                    key = { it.id } // 🔴 REQUIRED
                ) { dhikr ->

                    DhikrItem(
                        text = dhikr.text,
                        remaining = dhikr.remaining,
                        onClick = {
                            val index = adhkar.indexOfFirst { it.id == dhikr.id }
                            if (index != -1) {
                                val current = adhkar[index]
                                if (current.remaining > 1) {
                                    adhkar[index] =
                                        current.copy(remaining = current.remaining - 1)
                                } else {
                                    // ✅ remove when finished
                                    adhkar.removeAt(index)
                                }
                            }
                        }
                    )
                }
            }
        }
    }


}

