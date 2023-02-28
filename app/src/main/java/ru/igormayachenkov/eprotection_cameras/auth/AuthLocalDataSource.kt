package ru.igormayachenkov.eprotection_cameras.auth

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val AUTH_DATA = stringPreferencesKey("auth_data")

class AuthLocalDataSource(val dataStore: DataStore<Preferences>) {
    val data: Flow<AuthData> = dataStore.data
        .map { preferences ->
            //delay(1500)
            readValue(preferences)
        }
    
    suspend fun update(authData:AuthData) {
        dataStore.edit { preferences ->
            writeValue(preferences, authData)
        }
    }
    suspend fun updateUser(user:User?) {
        dataStore.edit { preferences ->
            val authData = readValue(preferences)
            writeValue(preferences,  authData.copy(user=user))
        }
    }

    // READ/WRITE UTILS
    private fun readValue(preferences:Preferences):AuthData =
        AuthData.fromString(preferences[AUTH_DATA])
    private fun writeValue(preferences: MutablePreferences, authData:AuthData)
        {preferences[AUTH_DATA] = authData.toString()}

}