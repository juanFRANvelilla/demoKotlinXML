package com.example.demoxml

import com.example.demoxml.MediaItem.*

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

fun getItems(): List<MediaItem> = (1..10).map {
    MediaItem("Title $it", "https://placekitten.com/200/200?image=$it", when(it % 3){ 0-> Type.VIDEO else -> Type.PHOTO})
}







//    MediaItem("Title 1", "https://placekitten.com/200/200?image=1", Type.PHOTO),
//    MediaItem("Title 2", "https://placekitten.com/200/200?image=2", Type.PHOTO),
//    MediaItem("Title 3", "https://placekitten.com/200/200?image=3", Type.PHOTO),
//    MediaItem("Title 4", "https://placekitten.com/200/200?image=4", Type.VIDEO),
//    MediaItem("Title 5", "https://placekitten.com/200/200?image=5", Type.PHOTO),
//    MediaItem("Title 6", "https://placekitten.com/200/200?image=6", Type.PHOTO),
//    MediaItem("Title 7", "https://placekitten.com/200/200?image=7", Type.VIDEO),
//    MediaItem("Title 8", "https://placekitten.com/200/200?image=8", Type.PHOTO),
//    MediaItem("Title 9", "https://placekitten.com/200/200?image=9", Type.PHOTO),
//    MediaItem("Title 10", "https://placekitten.com/200/200?image=10", Type.PHOTO)
