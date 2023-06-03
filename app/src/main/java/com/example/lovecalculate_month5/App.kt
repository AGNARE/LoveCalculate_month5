package com.example.lovecalculate_month5

import android.app.Application
import androidx.room.Room
import androidx.room.util.appendPlaceholders
import com.example.lovecalculate_month5.data.local.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var appDatabase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love_file")
                .allowMainThreadQueries().build()
    }

}