package info.sanaebadi.placeapp.util

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper(private val context: Context) {

    fun saveLong(key: String, value: Long) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun loadLong(key: String): Long {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getLong(key, 0L)
    }
}