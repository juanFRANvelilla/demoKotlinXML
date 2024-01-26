package com.example.demoxml

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Loger{

    override val tag: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)d
//        val recycler: RecyclerView = findViewById(R.id.recycler)
//        recycler.adapter = MediaAdapter(getItems())

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = MediaAdapter(getItems())  {
                toast(it.title)
            }
//        binding.recycler.adapter = MediaAdapter(getItems(), object : Listener{
//            override fun onClick(mediaItem: MediaItem) {
//                toast(mediaItem.title)
//            }
//        })


//        startActivity<MainActivity>()

        toast(test())
    }
}


inline fun <reified T: Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}



