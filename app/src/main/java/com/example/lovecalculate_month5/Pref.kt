package com.example.lovecalculate_month5

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {
    private var preferences: SharedPreferences? =
        context.getSharedPreferences("setting", Context.MODE_PRIVATE)

    fun isUserSeenOnBoard() {
        preferences?.edit()?.putBoolean(PREF_NAME, true)?.apply()
    }

    fun isUserSeen(): Boolean {
        return preferences!!.getBoolean(PREF_NAME, false)
    }

    companion object {

        const val PREF_NAME = "isShowing"
    }

}