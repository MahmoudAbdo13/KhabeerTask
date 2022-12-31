package com.mahomud.khabeertask

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.preference.PreferenceManager
import java.util.*

class Language(private val context: Context) {
    fun updateLanguage() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val language = prefs.getString("language", "ar")
        changeLanguage(context, language)
    }

    private fun changeLanguage(context: Context, lang: String?) {
        val myLocale = Locale(lang)
        Locale.setDefault(myLocale)
        val config = Configuration()
        config.locale = myLocale
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        saveLanguage(context, lang)
    }

    private fun saveLanguage(context: Context, language: String?) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPreferences.edit()
        editor.putString("language", language)
        editor.apply()
    }
}