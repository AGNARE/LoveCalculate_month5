package com.example.lovecalculate_month5

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Pref(context: Context) {
    private var preferences: SharedPreferences =
        context.getSharedPreferences(PREF_TITLE, MODE_PRIVATE)

    fun isUserSeen(): Boolean {
        return preferences.getBoolean(PREF_NAME, false)
    }

    fun isUserSeenOnBoard() {
        preferences.edit().putBoolean(PREF_NAME, true).apply()
    }

    companion object {
        const val PREF_TITLE = "setting"
        const val PREF_NAME = "isShowing"
    }

}