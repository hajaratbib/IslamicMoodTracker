package com.example.compose

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object UserPreferences {

    val Context.dataStore by preferencesDataStore(name = "user_prefs")
    private val NAME_KEY = stringPreferencesKey("username")
    private val ONBOARDING_KEY = booleanPreferencesKey("onboarding_completed")
    private val DHIKR_TYPE_KEY = stringPreferencesKey("dhikr_type")

    suspend fun saveName(context: Context, name: String) {
        context.dataStore.edit { prefs ->
            prefs[NAME_KEY] = name
        }
    }

    fun getName(context: Context): Flow<String?> =
        context.dataStore.data.map { it[NAME_KEY] ?: ""}

    suspend fun setOnboardingCompleted(context: Context) {
        context.dataStore.edit { it[ONBOARDING_KEY] = true }
    }

    fun isOnboardingCompleted(context: Context): Flow<Boolean> =
        context.dataStore.data.map { it[ONBOARDING_KEY] ?: false }

    suspend fun saveDhikrType(context: Context, dhikrType: String) {
        context.dataStore.edit { prefs ->
            prefs[DHIKR_TYPE_KEY] = dhikrType
        }
    }

    fun getDhikrType(context: Context): Flow<String?> =
        context.dataStore.data.map { it[DHIKR_TYPE_KEY] ?: ""}
}
