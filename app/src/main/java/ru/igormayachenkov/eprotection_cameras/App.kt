package ru.igormayachenkov.eprotection_cameras

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import ru.igormayachenkov.eprotection_cameras.auth.AuthRepository

private const val TAG = "myapp.App"

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class App : Application() {
    companion object{
        lateinit var instance:App
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "App onCreate")
        instance = this
    }
}