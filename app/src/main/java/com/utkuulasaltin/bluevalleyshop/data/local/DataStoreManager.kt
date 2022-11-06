package com.utkuulasaltin.bluevalleyshop.data.local

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_settings")

class DataStoreManager(context: Context) {
    private object  PreferencesKeys {
        val ON_BOARDING_VISIBLE = booleanPreferencesKey("on_boarding_visible")
        val USER_NAME = stringPreferencesKey("user_name")
    }

    private val dataStore = context.dataStore

    suspend fun setOnBoardingVisible(isVsible: Boolean) {
        dataStore.edit {mutablePreferences ->
        mutablePreferences[PreferencesKeys.ON_BOARDING_VISIBLE] = isVsible
        }
    }

    val getOnBoardingVisible: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[PreferencesKeys.ON_BOARDING_VISIBLE] ?: false
    }

    suspend fun setUserName(userName: String) {
        dataStore.edit { mutablePreferences ->
            mutablePreferences[PreferencesKeys.USER_NAME] = userName
        }
    }
}