package com.example.my_app.constant

sealed class Resultss<out T>{
    data class  Suceess<out T>(val data:T):Resultss<T>()
    data class  Error(val e:Exception):Resultss<Nothing>()
    object loading:Resultss<Nothing>()
}


