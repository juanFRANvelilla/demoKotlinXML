package com.example.demoxml

import com.example.demoxml.MediaItem.*

object MediaProvider {
    fun getItems(): List<MediaItem> = (1..10).map {
        MediaItem("Title $it", "https://placekitten.com/200/200?image=$it", when(it % 3){ 0-> Type.VIDEO else -> Type.PHOTO})
    }

}

//fun getItems(): List<MediaItem> {
//    var items: MutableList<MediaItem> = mutableListOf()
//    for(i in 1..10){
//        val name: String = "Title $i"
//        val url: String = "https://placekitten.com/200/200?image=$i"
//        val type: Type = when(i % 3){
//            0-> Type.VIDEO
//            else -> Type.PHOTO
//        }
//        items.add(MediaItem(name,url,type))
//
//    }
//    return items.toList()
//}





