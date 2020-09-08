package info.sanaebadi.placeapp.util

import android.content.Context

class PreferencesHelper(private val context: Context) {

    fun saveView(key: String, value: String) {
        val preferences =
            context.getSharedPreferences(Constants.PLACE_APP_SHARED_PREF, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun loadView(key: String): String? {
        val preferences =
            context.getSharedPreferences(Constants.PLACE_APP_SHARED_PREF, Context.MODE_PRIVATE)
        return preferences.getString(key,"")
    }
}