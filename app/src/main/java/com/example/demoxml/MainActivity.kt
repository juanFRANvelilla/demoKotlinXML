package com.example.demoxml

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.demoxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Loger{

    override val tag: String = javaClass.simpleName
    val adapter by lazy {MediaAdapter(getItems())  {
        toast(it.title)
    }}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.activity_main)d
//        val recycler: RecyclerView = findViewById(R.id.recycler)
//        recycler.adapter = MediaAdapter(getItems())

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
//        binding.recycler.adapter = MediaAdapter(getItems(), object : Listener{
//            override fun onClick(mediaItem: MediaItem) {
//                toast(mediaItem.title)
//            }
//        })
        adapter.items = getItems()

//        startActivity<MainActivity>()

//        toast(test())




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.items = getItems().let {
            when(item.itemId){
                R.id.filter_photos-> it.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> it.filter { it.type == MediaItem.Type.VIDEO }
                R.id.filter_all -> it
                else -> emptyList()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}



inline fun <reified T: Activity> Context.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}



