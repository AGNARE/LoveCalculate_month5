package com.example.lovecalculate_month5

import com.google.gson.annotations.SerializedName

class LoveModel(
    // @SerializedName нужен для того чтобы переименовать переменную чтоб мы сами понимали
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
):java.io.Serializable