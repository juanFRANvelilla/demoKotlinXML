package com.example.demoxml

import android.util.Log

interface Loger {

    val tag: String

    fun logD(message:String){
        Log.d(tag, message)
    }

}