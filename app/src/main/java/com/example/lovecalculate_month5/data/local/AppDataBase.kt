package com.example.lovecalculate_month5.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculate_month5.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): LoveDao
}