package com.example.lovecalculate_month5

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculate_month5.remote.LoveModel

class LoveViewModel : ViewModel() {

    // ViewModel (Представитель)
    // Связующее звено между моделью и представлением.
    //Отвечает за предоставление данных View и
    // обработку пользовательских действий.
    //Не зависит от конкретного View,
    // что позволяет переиспользовать ViewModel между различными View.
    //Содержит состояние приложения и методы для обновления состояния,
    // например, получение данных из модели, обработка пользовательского ввода
    // и управление взаимодействием с моделью.
    //Хранение состояния Обновление представления Обработка пользовательского ввода
    // Взаимодействие с моделью Независимость от представления Тестирование

    private val repository = Repository()

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveMutableLiveData(firstName, secondName)
    }
}