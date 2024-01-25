package com.example.demoxml

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View{
    return LayoutInflater
        .from(context)
        .inflate(R.layout.view_media_item, this, false)
}

fun ImageView.loadUrl(url: String){
    Glide.with(this).load(url).into(this)
}

fun Context.toast(s: String) {
    Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
}

//fun View.toast(s:String){
//    Toast.makeText(this.context, s, Toast.LENGTH_SHORT).show()
//}