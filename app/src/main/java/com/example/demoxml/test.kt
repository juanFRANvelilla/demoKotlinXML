package com.example.demoxml

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

fun test(): String{
    val sum: (Int, Int) -> Int = { x, y -> x + y}
    val mul = {x: Int, y: Int -> x * y}

    val res = doOp(2, 3, { x, y -> x - y })
    return res.toString()
}

fun doOp(x: Int, y: Int, op: (Int, Int) -> Int) = op(x,y)


interface Loger {

    val tag: String

    fun logD(message:String){
        Log.d(tag, message)
    }

}