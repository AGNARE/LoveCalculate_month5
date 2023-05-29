package com.example.lovecalculate_month5

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculate_month5.remote.LoveModel
import com.example.lovecalculate_month5.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    // MutableData может и наблюдать и изнемить данные
    // MutableLiveData позволяет наблюдать за данными но может его изменить по идее можно присвоить
    // данные но повверх него нельзя а в mutable можно
    // Repository  твечает за доступ к данным из различных источников, таких как база данных,
    // сетевые запросы, файлы и другие.
    // Он предоставляет абстракцию над источниками данных и скрывает детали реализации от ViewModel.
    //Управление данными:
    //
    //Repository отвечает за получение, сохранение,
    // обновление и удаление данных из различных источников.
    //Он может включать методы для выполнения запросов
    // к базе данных, отправки сетевых запросов или доступа к файловой системе.
    //Кэширование и обновление данных:
    //
    //Repository может обеспечивать механизм кэширования данных для улучшения производительности приложения.
    //Он также может обновлять данные из различных источников и оповещать ViewModel об изменениях данных.

    fun getLoveMutableLiveData(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        RetrofitService().api.getPercentage(firstName,secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.d("ololo", "onFailure: ${t.message}")
            }

        })

        return liveData
    }
}