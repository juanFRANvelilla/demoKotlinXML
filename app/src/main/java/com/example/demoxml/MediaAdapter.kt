package com.example.demoxml

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoxml.databinding.ViewMediaItemBinding
import kotlin.properties.Delegates

//interface Listener{
//    fun onClick(mediaItem: MediaItem)
//}

class MediaAdapter(items: List<MediaItem> = emptyList(), private val listener: (m: MediaItem) -> Unit) :
//class MediaAdapter(items: List<MediaItem> = emptyList(), private val listener: Listener) :
    RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    var items: List<MediaItem> by Delegates.observable(items){_, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
//        holder.itemView.setOnClickListener { listener.onClick(item) }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ViewMediaItemBinding.bind(view)

//        private val title = view.findViewById<TextView>(R.id.mediaTitle)
//        private val thumb = view.findViewById<ImageView>(R.id.mediaThumb)
//        private val vidoIndicator = view.findViewById<ImageView>(R.id.mediaVideoIndicator)

        fun bind(mediaItem: MediaItem) {
            with(binding) {
                mediaTitle.text = mediaItem.title
                mediaThumb.loadUrl(mediaItem.url)
                mediaVideoIndicator.visibility = when (mediaItem.type) {
                    MediaItem.Type.PHOTO -> View.GONE
                    MediaItem.Type.VIDEO -> View.VISIBLE
                }
            }
        }
    }
}




