package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.shared_preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(context: Context) {
    private var prefs: SharedPreferences =
        context.applicationContext.getSharedPreferences("local.pref", Context.MODE_PRIVATE)
    private val editor = prefs.edit()

    fun setStringPreference(prefKey: String, value: String) {
        editor.putString(prefKey, value)
        editor.apply()
    }

    fun setBooleanPreference(prefKey: String, value: Boolean) {
        editor.putBoolean(prefKey, value)
        editor.apply()
    }

    fun clearPreferenceByKey(prefKey: String) {
        editor.remove(prefKey)
        editor.apply()
    }

    fun getStringPreferences(prefKey: String): String? {
        return prefs.getString(prefKey, "")
    }

}