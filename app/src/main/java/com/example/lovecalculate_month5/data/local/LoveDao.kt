package com.example.lovecalculate_month5.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculate_month5.remote.LoveModel

@Dao
interface  LoveDao {
    @Insert
    fun insert(loveModel: LoveModel)

    @Query("Select * FROM love_table")
    fun getAll(): List<LoveModel>

    @Query("Select * FROM love_table ORDER BY firstName ASC")
    fun getAllSort(): List<LoveModel>
}