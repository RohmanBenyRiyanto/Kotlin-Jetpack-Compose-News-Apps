package com.learncompose.data.manager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.learncompose.domain.manager.LocalUserManager
import com.learncompose.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppOpened() {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.APP_OPENED] = true
        }
    }

    override fun readAppOpened(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_OPENED] ?: false
        }
    }
}

private val Context.dataStore by preferencesDataStore(name = Constants.USER_SETTINGS)

private object PreferencesKeys {
    val APP_OPENED = booleanPreferencesKey(name = Constants.APP_OPENED)
}
