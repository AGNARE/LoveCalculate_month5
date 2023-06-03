package com.example.lovecalculate_month5.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_table")
class LoveModel(
    // @SerializedName нужен для того чтобы переименовать переменную чтоб мы сами понимали
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int
):java.io.Serializable